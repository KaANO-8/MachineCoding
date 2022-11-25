package vendingmachine2

import vendingmachine2.state.Idle
import vendingmachine2.state.State

class VendingMachine {

    private var currentState: State = Idle(this)
    private var amount: Double = 0.0


    fun start() {
        currentState.showAvailableItems(listOf())
    }

    fun updateAmount(amount: Double) {
        this.amount = amount
    }

    fun updateState(updatedState: State) {

    }

    fun printItems(items: List<String>) {
        println(items.joinToString())
    }
}