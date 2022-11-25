package shoppingcartdiscount

import shoppingcartdiscount.models.Item
import shoppingcartdiscount.models.ShoppingCart
import shoppingcartdiscount.models.User
import shoppingcartdiscount.shipping.NonPrime1DayShipping
import shoppingcartdiscount.shipping.NonPrime2DayShipping
import shoppingcartdiscount.shipping.Prime2HourShipping
import shoppingcartdiscount.shipping.PrimeMemberFree2Day

fun main() {
    val user1 = User("Rahul", password = "123", primeCustomer = true)
    val user2 = User("Aditi", password = "123", primeCustomer = false)

    val shoppingCart1 = ShoppingCart().apply {
        addItem(Item(price = 25.0))
        addItem(Item(price = 25.0))
        addItem(Item(price = 25.0))
    }

    val shoppingCart2 = ShoppingCart().apply {
        addItem(Item(price = 25.0))
        //addItem(Item(price = 25.0))
    }

    val primeDelivery2Day = PrimeMemberFree2Day()
    val primeDelivery2Hours = Prime2HourShipping()
    val nonPrime2Day = NonPrime2DayShipping()
    val nonPrime1Day = NonPrime1DayShipping()

    primeDelivery2Day.next = primeDelivery2Hours
    primeDelivery2Hours.next = nonPrime2Day
    nonPrime2Day.next = nonPrime1Day

    println(primeDelivery2Day.calculateShippingDays(user1, shoppingCart1)/24.0)
    println(primeDelivery2Day.calculateShippingDays(user2, shoppingCart2)/24.0)

}