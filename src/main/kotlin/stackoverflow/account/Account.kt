package stackoverflow.account

import stackoverflow.constants.AccountStatus

data class Account(
    val id: String,
    val password: String,
    val status: AccountStatus,
    val name: String,
    val email: String,
    val phone: String,
    var reputation: Int
) {
    fun resetPassword() {

    }
}
