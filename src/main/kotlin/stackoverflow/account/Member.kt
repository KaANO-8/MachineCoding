package stackoverflow.account

import stackoverflow.extras.Badge
import stackoverflow.extras.Tag
import stackoverflow.question.Question

open class Member {
    private lateinit var account: Account
    private lateinit var badges: List<Badge>

    fun getReputation() =
        account.reputation

    fun getEmail() = account.email

    fun createQuestion(question: Question): Boolean{
        TODO()
    }

    fun createTag(tag: Tag): Boolean {
        TODO()
    }
}