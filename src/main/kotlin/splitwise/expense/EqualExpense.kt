package splitwise.expense

import splitwise.user.User
import splitwise.split.EqualSplit
import splitwise.split.Split

class EqualExpense(amount: Double, paidBy: User, splits: List<Split>, expenseMetadata: ExpenseMetadata): Expense(amount, paidBy, splits, expenseMetadata) {
    override fun validate(): Boolean {
        for (split in splits)
            if (split !is EqualSplit)
                return false

        return true
    }
}