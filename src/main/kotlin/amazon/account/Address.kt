package amazon.account

data class Address(
    val streetAddress: String,
    val city: String,
    val state: String,
    val zipCode: String,
    val country: String
)