package shoppingcartdiscount.shipping

import shoppingcartdiscount.models.ShoppingCart
import shoppingcartdiscount.models.User

abstract class ShippingDayHandler: ShippingDayContract {
    var next: ShippingDayHandler? = null

    override fun calculateShippingDays(user: User, shoppingCart: ShoppingCart): Int {
        return next?.calculateShippingDays(user, shoppingCart) ?: 120 // default 5 days
    }
}