package vendingmachine.models

enum class Item(val productName: String, val price: Long) {
    COKE("Coke", 25),
    PEPSI("Pepsi", 35),
    SODA("soda", 45)
}