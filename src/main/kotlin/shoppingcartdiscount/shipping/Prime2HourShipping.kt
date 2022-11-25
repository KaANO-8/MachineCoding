package shoppingcartdiscount.shipping

import shoppingcartdiscount.models.ShoppingCart
import shoppingcartdiscount.models.User

class Prime2HourShipping: ShippingDayHandler() {
    override fun calculateShippingDays(user: User, shoppingCart: ShoppingCart): Int {
        // Rule
        if (user.primeCustomer && shoppingCart.totalAmount() > 25)
            return 2

        return super.calculateShippingDays(user, shoppingCart)
    }
}