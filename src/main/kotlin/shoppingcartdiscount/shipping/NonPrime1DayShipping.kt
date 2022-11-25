package shoppingcartdiscount.shipping

import shoppingcartdiscount.models.ShoppingCart
import shoppingcartdiscount.models.User

class NonPrime1DayShipping: ShippingDayHandler() {
    override fun calculateShippingDays(user: User, shoppingCart: ShoppingCart): Int {
        // Rule
        if (user.primeCustomer.not() && shoppingCart.totalAmount() > 125.0)
            return 24

        return super.calculateShippingDays(user, shoppingCart)
    }
}