package vendingmachine.exceptions

import java.lang.RuntimeException

class NotSufficientChangeException(val messageEx: String): RuntimeException()