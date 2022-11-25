package splitwise.split

import splitwise.user.User

class ExactSplit(user: User, amount: Double): Split(user) {
    init {
        this.amount = amount
    }
}