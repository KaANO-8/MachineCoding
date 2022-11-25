package splitwise.expense

import splitwise.user.User
import splitwise.split.Split

abstract class Expense(val amount: Double, val paidBy: User, val splits: List<Split>, val expenseMetadata: ExpenseMetadata) {
    abstract fun validate(): Boolean
}