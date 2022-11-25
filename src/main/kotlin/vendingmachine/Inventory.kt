package vendingmachine

import vendingmachine.exceptions.SoldOutException

class Inventory<T> {
    private val inventory = mutableMapOf<T, Int>()

    fun addItem(item: T) {
        inventory[item] = inventory.getOrDefault(item, 0) + 1
    }

    fun deduct(item: T) {
        if(item in inventory) {
            inventory[item] = inventory.getOrDefault(item, 0) - 1
            if(inventory.getOrDefault(item, 0) == 0)
                inventory.remove(item)
        }
        throw SoldOutException("There is no $item in inventory")
    }

    fun getQuantity(item: T): Int =
        inventory.getOrDefault(item, 0)

    fun hasItem(item: T): Boolean =
        item in inventory

    fun clear() {
        inventory.clear()
    }

    fun put(item: T, quantity: Int) {
        inventory[item] = quantity
    }
}