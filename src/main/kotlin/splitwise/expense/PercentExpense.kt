package splitwise.expense

import splitwise.user.User
import splitwise.split.PercentSplit
import splitwise.split.Split

class PercentExpense(amount: Double, paidBy: User, splits: List<Split>, expenseMetadata: ExpenseMetadata): Expense(amount, paidBy, splits, expenseMetadata) {
    override fun validate(): Boolean {
        var percent = 0.0
        for (split in splits) {
            if (split !is PercentSplit)
                return false
            percent += split.percent
        }
        return percent == 100.0
    }
}