package vendingmachine2.state

import vendingmachine2.VendingMachine

abstract class State(val vendingMachine: VendingMachine) {
    abstract fun showAvailableItems(items: List<String>)
    abstract fun insertCoin(amount: Double)
    abstract fun pressButton(punchNumber: Int)
    abstract fun dispenseItem(productCode: String)
}