package amazon.shopping

data class Item(var itemId: String, var quantity: Int, val price: Double) {
    fun updateQuantity(newQuantity: Int) {
        quantity = newQuantity
    }
}
