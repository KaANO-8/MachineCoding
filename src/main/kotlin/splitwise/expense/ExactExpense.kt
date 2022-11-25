package splitwise.expense

import splitwise.user.User
import splitwise.split.ExactSplit
import splitwise.split.Split

class ExactExpense(amount: Double, paidBy: User, splits: List<Split>, expenseMetadata: ExpenseMetadata): Expense(amount, paidBy, splits, expenseMetadata) {
    override fun validate(): Boolean {
        var sum = 0.0
        for (split in splits) {
            if (split !is ExactSplit)
                return false
            sum += split.amount
        }
        return sum == amount
    }
}