package amazon.account

import amazon.order.Order
import amazon.shopping.Item
import amazon.shopping.ShoppingCart

abstract class Customer {
    private val cart: ShoppingCart = ShoppingCart()
}