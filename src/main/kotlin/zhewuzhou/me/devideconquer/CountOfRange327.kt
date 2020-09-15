package zhewuzhou.me.devideconquer

/*
1. Why start from 0 and sortedSum[0] = 0?
 */
fun countRangeSum(nums: IntArray, lower: Int, upper: Int): Int {
    val merging = LongArray(nums.size + 1)
    val merged = LongArray(nums.size + 1)
    var count = 0
    merging[0] = 0
    for (i in 1..nums.size) {
        merging[i] = merging[i - 1] + nums[i - 1].toLong()
    }
    fun mergesort(start: Int, end: Int) {
        if (start >= end) {
            return
        }
        val mid = start + (end - start) / 2
        mergesort(start, mid)
        mergesort(mid + 1, end)
        var right = mid + 1
        var index = start
        var low = mid + 1
        var high = mid + 1
        for (left in start..mid) {
            while (low <= end && merging[low] - merging[left] < lower) {
                low++
            }
            while (high <= end && merging[high] - merging[left] <= upper) {
                high++
            }
            while (right <= end && merging[right] < merging[left]) {
                merged[index++] = merging[right++]
            }
            merged[index++] = merging[left]
            count += high - low
        }
        while (right <= end) {
            merged[index++] = merging[right++]
        }
        for (i in start..end) {
            merging[i] = merged[i]
        }
    }
    mergesort(0, merging.size - 1)
    return count
}


