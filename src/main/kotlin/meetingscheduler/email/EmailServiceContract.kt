package meetingscheduler.email

interface EmailServiceContract {
    fun sendBulkEmail(template: String, emails: List<String>, model: Map<String, Any>)
    fun sendEmail(template: String, email: String, model: Map<String, Any>)
}