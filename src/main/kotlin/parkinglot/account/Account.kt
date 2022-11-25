package parkinglot.account

import parkinglot.enums.AccountStatus

data class Account(val username: String, val password: String, var accountStatus: AccountStatus) {
    fun resetPassword() {
        // Add code to reset password
    }
}
