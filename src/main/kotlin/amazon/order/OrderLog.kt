package amazon.order

import amazon.enums.OrderStatus
import java.util.Date

data class OrderLog(val orderNum: String, val creationDate: Date, val orderStatus: OrderStatus)
