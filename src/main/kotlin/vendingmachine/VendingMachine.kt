package vendingmachine

import vendingmachine.models.Coin
import vendingmachine.models.Item

interface VendingMachine {
    fun selectItemAndGetPrice(item: Item): Long
    fun insertCoin(coin: Coin)
    fun refund(): List<Coin>
    fun collectItemAndChange(): Pair<Item, List<Coin>>
    fun reset()
}