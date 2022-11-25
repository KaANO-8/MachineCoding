package amazon.product

import amazon.account.Account

data class Product(
    val productId: Int,
    val name: String,
    val desc: String,
    var price: Double,
    val category: ProductCategory,
    var availableItems: Int,
    val seller: Account
) {
    fun getAvailableCount() = availableItems

    fun updatePrice(newPrice: Double) {
        price = newPrice
    }
}
