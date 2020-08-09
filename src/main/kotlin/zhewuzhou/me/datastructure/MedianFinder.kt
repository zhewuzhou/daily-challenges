package zhewuzhou.me.datastructure

import java.util.*

/*
Set is not working because element could be duplicated
 */
class MedianFinder() {
    private val large = PriorityQueue<Int>()
    private val small = PriorityQueue<Int>()
    fun addNum(num: Int) {
        if (large.isNotEmpty() && num < large.peek()) {
            small.add(0 - num)
        } else {
            large.add(num)
        }
        if (large.size > small.size + 1) {
            small.add(0 - large.poll())
        }
        if (small.size > large.size) {
            large.add(0 - small.poll())
        }
    }

    fun findMedian(): Double {
        if (small.size == large.size) {
            return (0 - small.peek() + large.peek()) / 2.0
        }
        return large.peek().toDouble()
    }
}
