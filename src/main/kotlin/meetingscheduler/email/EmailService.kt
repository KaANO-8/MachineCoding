package meetingscheduler.email

class EmailService(private val client: EmailClient): EmailServiceContract {
    override fun sendBulkEmail(template: String, emails: List<String>, model: Map<String, Any>) {
        for (email in emails) {
            client.sendEmail(template, email, model)
        }
    }

    override fun sendEmail(template: String, email: String, model: Map<String, Any>) {
        client.sendEmail(template, email, model)
    }
}
