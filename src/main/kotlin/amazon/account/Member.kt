package amazon.account

import amazon.enums.OrderStatus
import amazon.order.Order
import amazon.product.ProductReview

class Member: Customer() {
    private lateinit var account: Account
    private lateinit var orders: List<Order>

    fun placeOrder(order: Order): OrderStatus {
        return OrderStatus.COMPLETED
    }


}