package splitwise.split

import splitwise.user.User

class PercentSplit(user: User, var percent: Double): Split(user) {
}