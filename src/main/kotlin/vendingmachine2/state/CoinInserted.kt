package vendingmachine2.state

import vendingmachine2.VendingMachine

class CoinInserted(vendingMachine: VendingMachine): State(vendingMachine) {

    override fun showAvailableItems(items: List<String>) {
        TODO("Not yet implemented")
    }

    override fun insertCoin(amount: Double) {
       TODO()
    }

    override fun pressButton(punchNumber: Int) {
        TODO("Not yet implemented")
    }

    override fun dispenseItem(productCode: String) {
        TODO("Not yet implemented")
    }
}