package meetingscheduler.model

import java.util.*
// Assumption here is that each meeting room has infinite meeting slots.
// In real world we'll be driving this using java's calendar class so slots will be fixed
class MeetingRoom(val id: String = UUID.randomUUID().toString(), val name: String) {
    private val calendar: Calendar = Calendar(this)

    fun isAvailable(start: Int, end: Int): Boolean =
        calendar.checkAvailability(start, end)

    fun scheduleMeeting(name: String, start: Int, end: Int): Meeting =
        calendar.scheduleMeeting(name, start, end)
}
