package splitwise.service

import splitwise.expense.*
import splitwise.split.PercentSplit
import splitwise.split.Split
import splitwise.user.User

class ExpenseFactory: ExpenseService {
    override fun createExpense(
        expenseType: ExpenseType,
        amount: Double,
        paidBy: User,
        splits: List<Split>,
        expenseMetadata: ExpenseMetadata
    ): Expense {
        return when(expenseType) {
            ExpenseType.EXACT -> {
                ExactExpense(amount, paidBy, splits, expenseMetadata)
            }
            ExpenseType.PERCENT -> {
                for (split in splits) {
                    val percentSplit = (split as PercentSplit).percent
                    split.amount = amount * (percentSplit / 100)
                }

                PercentExpense(amount, paidBy, splits, expenseMetadata)
            }
            ExpenseType.EQUAL -> {
                val splitShare = amount / splits.size
                for (split in splits)
                    split.amount = splitShare

                EqualExpense(amount, paidBy, splits, expenseMetadata)
            }
        }
    }
}