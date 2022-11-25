package apiratelimiter.ratelimiters

import apiratelimiter.RateLimiter
import apiratelimiter.model.Log
import java.util.concurrent.BlockingDeque
import java.util.concurrent.LinkedBlockingDeque

class SlidingWindowCounter(private val time: Int, private val maxAllowedRequests: Int) : RateLimiter {
    private val buckets: MutableMap<String, BlockingDeque<Log>> = mutableMapOf()

    override fun grantAccess(userId: String, requestTime: Long): Boolean {
        if (userId in buckets) {
            updateQueue(buckets[userId]!!)

            return if (getAccessCount(buckets[userId]!!) < maxAllowedRequests) {
                insertEntry(buckets[userId]!!, requestTime)
                true
            } else {
                println("Log error")
                false
            }

        }
        buckets[userId] = LinkedBlockingDeque(maxAllowedRequests)
        insertEntry(buckets[userId]!!, requestTime)
        return true
    }

    private fun updateQueue(queue: BlockingDeque<Log>) {
        val currentTime = System.currentTimeMillis()
        var oldestEntryTime = currentTime - queue.peek().time
        while (oldestEntryTime > time) {
            queue.poll()
            if (queue.isEmpty())
                return
            oldestEntryTime = currentTime - queue.peek().time
        }
    }

    private fun getAccessCount(queue: BlockingDeque<Log>) =
        queue.sumOf { it.count }

    private fun insertEntry(queue: BlockingDeque<Log>, requestTime: Long) {
        if (queue.isEmpty()) {
            queue.offer(Log(requestTime, 1))
            return
        }

        val lastItem = queue.peekLast()
        if (lastItem.time == requestTime)
            lastItem.count++
        else
            queue.offer(Log(requestTime, 1))
    }
}
