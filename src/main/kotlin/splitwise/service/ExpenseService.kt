package splitwise.service

import splitwise.expense.Expense
import splitwise.expense.ExpenseMetadata
import splitwise.expense.ExpenseType
import splitwise.split.Split
import splitwise.user.User

interface ExpenseService {
    fun createExpense(
        expenseType: ExpenseType,
        amount: Double,
        paidBy: User,
        splits: List<Split>,
        expenseMetadata: ExpenseMetadata
    ): Expense
}