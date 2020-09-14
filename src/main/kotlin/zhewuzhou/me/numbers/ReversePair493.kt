package zhewuzhou.me.numbers

fun reversePairs(nums: IntArray): Int {
    fun sort(start: Int, end: Int): Int {
        if (start >= end) return 0
        val mid = start + (end - start) / 2
        val mergeSpace = IntArray(nums.size)
        var count = sort(start, mid) + sort(mid + 1, end)
        for (i in start..end) {
            mergeSpace[i] = nums[i]
        }
        var left = start
        var right = mid + 1
        for (i in start..end) {
            if (left == mid + 1) {
                nums[i] = mergeSpace[right++]
            } else if (right == end + 1 || mergeSpace[left] <= mergeSpace[right]) {
                count += (mid + 1..end).filter { mergeSpace[left].toLong() > 2L * mergeSpace[it].toLong() }.count()
                nums[i] = mergeSpace[left++]
            } else {
                nums[i] = mergeSpace[right++]
            }
        }
        return count
    }
    return sort(0, nums.lastIndex)
}
