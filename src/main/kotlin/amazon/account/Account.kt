package amazon.account

import amazon.enums.AccountStatus
import amazon.payment.Cards
import amazon.product.Product
import amazon.product.ProductReview

class Account(
    val username: String,
    val password: String,
    val accountStatus: AccountStatus,
    val name: String,
    val shippingAddresses: List<Address>,
    val email: String,
    val phone: String,
    val addedCards: List<Cards>
) {
    fun addProduct(product: Product): Boolean {
        return true
    }

    fun addProductReview(review: ProductReview): Boolean {
        return true
    }

    fun resetPassword(): Boolean {
        return true
    }
}
