package vendingmachine.exceptions

import java.lang.RuntimeException

class NotFullPaidException(val messageEx: String): RuntimeException()