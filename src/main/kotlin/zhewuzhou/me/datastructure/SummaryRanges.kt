package zhewuzhou.me.datastructure

import java.util.*

class SummaryRanges {
    private val ranges = TreeMap<Int, Pair<Int, Int>>()
    fun addNum(v: Int) {
        if (ranges.containsKey(v)) return
        /*
        floorKey/ceilingKey is the same
         */
        val low = ranges.lowerKey(v)
        val high = ranges.higherKey(v)
        val isContiguous = low != null && high != null && ranges[low]!!.second + 1 == v && v + 1 == ranges[high]!!.first
        if (isContiguous) {
            ranges[low] = Pair(ranges[low]!!.first, ranges[high]!!.second)
            ranges.remove(high)
        } else if (low != null && ranges[low]!!.second + 1 >= v) {
            ranges[low] = Pair(ranges[low]!!.first, Math.max(ranges[low]!!.second, v))
        } else if (high != null && high == v + 1) {
            ranges[v] = Pair(v, ranges[high]!!.second)
            ranges.remove(high)
        } else {
            ranges[v] = Pair(v, v)
        }
    }

    fun getIntervals(): Array<IntArray> =
        ranges.values.toSet().map { intArrayOf(it.first, it.second) }.toTypedArray()
}
