package meetingscheduler.model

import java.util.PriorityQueue

class Calendar(private val meetingRoom: MeetingRoom) {
    private val meetings = PriorityQueue(compareBy<Meeting> { it.startTime }.thenBy { it.endTime })

    fun checkAvailability(start: Int, end: Int): Boolean {
        for (meeting in meetings) {
            // check for overlap
            if(meeting.startTime < end || meeting.endTime > start)
                // found 1 conflicting meeting here, so return
                return false
        }
        // available to schedule
        return true
    }

    fun scheduleMeeting(name: String, start: Int, end: Int): Meeting {
        val meeting = Meeting(name = name, startTime = start, endTime = end, meetingRoom = meetingRoom)
        meetings.add(meeting)
        return meeting
    }
}