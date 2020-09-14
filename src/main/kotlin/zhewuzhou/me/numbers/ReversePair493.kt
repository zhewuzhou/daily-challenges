package zhewuzhou.me.numbers

import java.util.*

/*
TODO: Decouple count with sort
 */
fun reversePairs(nums: IntArray): Int {
    fun sort(start: Int, end: Int): Int {
        if (start >= end) return 0
        val mid = start + (end - start) / 2
        var count = sort(start, mid) + sort(mid + 1, end)
        var left = start
        var right = mid + 1
        while (left <= mid) {
            while (right <= end && nums[left] / 2.0 > nums[right]) {
                right += 1
            }
            count += right - (mid + 1)
            left += 1
        }
        Arrays.sort(nums, start, end + 1)
        return count
    }
    return sort(0, nums.lastIndex)
}
