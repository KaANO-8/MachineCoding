package vendingmachine2.state

import vendingmachine2.VendingMachine

class Idle(vendingMachine: VendingMachine): State(vendingMachine) {
    override fun showAvailableItems(items: List<String>) {
        vendingMachine.printItems(items)
    }

    override fun insertCoin(amount: Double) {
        // Nothing to do
    }

    override fun pressButton(punchNumber: Int) {
        // Nothing to do
    }

    override fun dispenseItem(productCode: String) {
        // Nothing to do
    }
}