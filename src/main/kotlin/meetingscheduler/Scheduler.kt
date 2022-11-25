package meetingscheduler

import meetingscheduler.exception.NoRoomAvailableException
import meetingscheduler.model.Attendee
import meetingscheduler.model.Meeting
import meetingscheduler.model.MeetingRoom
import java.util.*
import kotlin.jvm.Throws

class Scheduler(private val meetingRooms: List<MeetingRoom>, private val maxHistoryCount: Int) {
    private val history: Queue<Meeting> = LinkedList()

    @Throws(NoRoomAvailableException::class)
    @Synchronized fun scheduleMeeting(name: String, start: Int, end: Int, attendees: List<Attendee>): Meeting {
        for (room in meetingRooms) {
            if (room.isAvailable(start, end)) {
                val meeting = room.scheduleMeeting(name, start, end)
                meeting.invite(attendees)
                saveToHistory(meeting)
                return meeting
            }
        }
        throw NoRoomAvailableException("No meeting rooms available")
    }

    private fun saveToHistory(meeting: Meeting) {
        history.offer(meeting)
        if (history.size > maxHistoryCount)
            history.poll()
    }

    fun getHistoryOfMeetings():List<Meeting> = history.toList()
}