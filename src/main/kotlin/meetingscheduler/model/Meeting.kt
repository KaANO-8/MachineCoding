package meetingscheduler.model

import meetingscheduler.email.EmailClient
import meetingscheduler.email.EmailService
import meetingscheduler.email.EmailServiceContract
import java.util.UUID

data class Meeting(
    val id: String = UUID.randomUUID().toString(),
    private val name: String,
    val startTime: Int,
    val endTime: Int,
    private val meetingRoom: MeetingRoom,
    private val emailService: EmailServiceContract = EmailService(EmailClient())
) {
    fun invite(attendees: List<Attendee>) {
        emailService.sendBulkEmail(EMAIL_NOTIFICATION_TEMPLATE, attendees.map { it.email }, mapOf(name to this))
    }

    companion object {
        private const val EMAIL_NOTIFICATION_TEMPLATE = ""
    }
}
