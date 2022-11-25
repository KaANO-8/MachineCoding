package apiratelimiter

interface RateLimiter {
    fun grantAccess(userId: String, requestTime: Long): Boolean
}