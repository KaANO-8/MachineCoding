package vendingmachine.exceptions

import java.lang.RuntimeException

class SoldOutException(val messageEx: String): RuntimeException()