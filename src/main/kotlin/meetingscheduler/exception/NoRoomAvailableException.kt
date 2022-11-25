package meetingscheduler.exception

import java.lang.RuntimeException

class NoRoomAvailableException(message: String): RuntimeException(message)