package shoppingcartdiscount.shipping

import shoppingcartdiscount.models.ShoppingCart
import shoppingcartdiscount.models.User

class PrimeMemberFree2Day: ShippingDayHandler() {
    override fun calculateShippingDays(user: User, shoppingCart: ShoppingCart): Int {
        // Rule
        if (user.primeCustomer && shoppingCart.totalAmount() <= 25)
            return 48

        return super.calculateShippingDays(user, shoppingCart)
    }
}