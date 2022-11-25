package splitwise

import splitwise.expense.Expense
import splitwise.expense.ExpenseMetadata
import splitwise.expense.ExpenseType
import splitwise.service.ExpenseFactory
import splitwise.service.ExpenseService
import splitwise.split.Split
import splitwise.user.User
import java.util.PriorityQueue

class ExpenseManager(private val expenseService: ExpenseService = ExpenseFactory()) {
    private val users = mutableMapOf<String, User>()
    private val expenses = mutableListOf<Expense>()
    private val balanceSheet = mutableMapOf<String, MutableMap<String, Double>>()

    fun addUser(user: User) {
        users[user.id] = user
        balanceSheet[user.id] = mutableMapOf()
    }

    fun addExpense(
        expenseType: ExpenseType,
        amount: Double,
        paidBy: User,
        splits: List<Split>,
        expenseMetadata: ExpenseMetadata
    ) {
        val expense = expenseService.createExpense(expenseType, amount, paidBy, splits, expenseMetadata)

        for (split in splits) {
            val paidTo = split.user

            // If A -> B $10
            // A ---- B +10 // doing this way if we sum up values of a map, we get exact value whether this user is in profit or loss

            // B ---- A -10

            balanceSheet[paidBy.id] = balanceSheet.getOrDefault(paidBy.id, mutableMapOf())
                .apply { this[paidTo.id] = this.getOrDefault(paidTo.id, 0.0) + split.amount }

            balanceSheet[paidTo.id] = balanceSheet.getOrDefault(paidTo.id, mutableMapOf())
                .apply { this[paidBy.id] = this.getOrDefault(paidBy.id, 0.0) - split.amount }
        }
    }

    fun showBalance(user: User) {
        val balance = balanceSheet[user.id]
        if (balance != null) {
            for ((paidTo, amount) in balance) {
                if (amount != 0.0)
                    printBalance(user.name, users[paidTo]!!.name, amount)
            }
        }
    }

    fun showBalances() {
        // Traverse 2 maps and show
    }

    fun simplifyDebts(): List<String> {
        val userBalances = getEachUserBalance()
        val simplifiedDebts = mutableListOf<String>()
        val posBalHeap = PriorityQueue<Pair<String, Double>>(compareByDescending { it.second })
        val negBalHeap = PriorityQueue<Pair<String, Double>>(compareByDescending { it.second })

        for ((user, balance) in userBalances) {
            if (balance > 0)
                posBalHeap.offer(Pair(user, balance))
            else if(balance < 0)
                negBalHeap.offer(Pair(user, balance * -1.0))
        }

        while (posBalHeap.isNotEmpty()) {
            val posTop = posBalHeap.poll()
            val negTop = negBalHeap.poll()

            val balanceAmount = posTop.second - negTop.second

            if (balanceAmount > 0) {
                posBalHeap.offer(Pair(posTop.first, balanceAmount))
                simplifiedDebts.add("${negTop.first} paid ${posTop.first} ${negTop.second}")
            } else if (balanceAmount < 0) {
                negBalHeap.offer(Pair(negTop.first, balanceAmount * -1.0))
                simplifiedDebts.add("${negTop.first} paid ${posTop.first} ${posTop.second}")
            }
        }


        return simplifiedDebts
    }

    private fun getEachUserBalance(): Map<String, Double> {
        val userBalance = mutableMapOf<String, Double>()
        for ((sender, balances) in balanceSheet) {
            var totalAmount = 0.0
            for ((_, amount) in balances)
                totalAmount += amount
            userBalance[sender] = totalAmount
        }
        return userBalance
    }


    private fun printBalance(paidBy: String, paidTo: String, amount: Double) {
        if (amount > 0) {
            println("$paidTo owes $amount to $paidBy")
        } else {
            println("$paidBy owes $amount to $paidTo")
        }
    }
}