package amazon.shopping

class ShoppingCart {
    private lateinit var items: MutableList<Item>

    fun addItem(item: Item) {
        // do ops on list
    }

    fun removeItem(item: Item) {
        // do ops on list
    }

    fun updateItemQuantity(itemId: String, updatedQuantity: Int) {
        items.firstOrNull { it.itemId == itemId }?.updateQuantity(updatedQuantity)
    }

    fun checkout() {

    }
}