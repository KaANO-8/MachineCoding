package splitwise.split

import splitwise.user.User

abstract class Split(val user: User) {
    var amount: Double = 0.0
}