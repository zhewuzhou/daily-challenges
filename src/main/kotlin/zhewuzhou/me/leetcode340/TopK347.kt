package zhewuzhou.me.leetcode340

import java.util.*

/*
Solution 2
1. HashMap<Int, Int> element -> count
2. TreeMap<Int, List<Int>> count -> elements
 */

class CountableElement(val count: Int, val ele: Int) : Comparable<CountableElement> {
    override fun compareTo(other: CountableElement): Int {
        return this.count.compareTo(other.count)
    }
}

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val count = mutableMapOf<Int, Int>()
    for (n in nums) {
        count[n] = if (count.containsKey(n)) count[n]!! + 1 else 1
    }
    val countableElements = count.map { CountableElement(-it.value, it.key) }
    val queue = PriorityQueue<CountableElement>(countableElements)
    val res = IntArray(k) { 0 }
    var cur = 0
    while (cur < k) {
        val peek = queue.poll()
        res[cur] = peek.ele
        cur += 1
    }
    return res
}
