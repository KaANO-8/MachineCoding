package shoppingcartdiscount.shipping

import shoppingcartdiscount.models.ShoppingCart
import shoppingcartdiscount.models.User

interface ShippingDayContract {
    fun calculateShippingDays(user: User, shoppingCart: ShoppingCart): Int
}