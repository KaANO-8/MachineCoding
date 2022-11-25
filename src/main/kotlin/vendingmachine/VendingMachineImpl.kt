package vendingmachine

import vendingmachine.exceptions.SoldOutException
import vendingmachine.models.Coin
import vendingmachine.models.Item

class VendingMachineImpl: VendingMachine {

    private val cashInventory = Inventory<Coin>()
    private val itemInventory = Inventory<Item>()
    private var totalSales: Long = 0L
    private lateinit var currentItem: Item
    private var currentBalance: Long = 0L

    init {
        for (c in Coin.values())
            cashInventory.put(c, 5)

        for (i in Item.values())
            itemInventory.put(i, 5)
    }

    override fun selectItemAndGetPrice(item: Item): Long {
        if (itemInventory.hasItem(item)) {
            currentItem = item
            return currentItem.price
        }
        throw SoldOutException("Item sold out")
    }

    override fun insertCoin(coin: Coin) {
        currentBalance += coin.denomination
        cashInventory.addItem(coin)
    }

    override fun refund(): List<Coin> {
        TODO("Not yet implemented")
    }

    override fun collectItemAndChange(): Pair<Item, List<Coin>> {
        TODO("Not yet implemented")
    }

    override fun reset() {
        TODO("Not yet implemented")
    }
}