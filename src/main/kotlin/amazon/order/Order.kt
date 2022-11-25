package amazon.order

import amazon.enums.OrderStatus
import java.util.Date

data class Order(val orderId: Int, var orderStatus: OrderStatus, val orderDate: Date, val orderLog: List<OrderLog>) {
    fun sendForShipment(): Boolean {
        return true
    }

    fun makePayment() {

    }

    fun addOrderLog() {

    }
}
