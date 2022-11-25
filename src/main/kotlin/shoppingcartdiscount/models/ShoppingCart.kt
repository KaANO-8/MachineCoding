package shoppingcartdiscount.models


class ShoppingCart {
    private val cart = mutableListOf<Item>()

    fun getItemsInCart(): List<Item> = cart

    fun addItem(item: Item) {
        cart.add(item)
    }

    fun totalAmount(): Double {
        return cart.sumOf { it.price }
    }
}