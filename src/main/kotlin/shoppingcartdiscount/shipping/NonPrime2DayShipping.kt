package shoppingcartdiscount.shipping

import shoppingcartdiscount.models.ShoppingCart
import shoppingcartdiscount.models.User

class NonPrime2DayShipping: ShippingDayHandler() {
    override fun calculateShippingDays(user: User, shoppingCart: ShoppingCart): Int {
        // rule
        if (!user.primeCustomer && shoppingCart.totalAmount() in (35.0..125.0))
            return 48

        return super.calculateShippingDays(user, shoppingCart)
    }
}