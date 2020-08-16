package zhewuzhou.me.leetcode340

fun countRangeSum(nums: IntArray, lower: Int, upper: Int): Int {
    val sortedSum = LongArray(nums.size + 1)
    val sortingSpace = LongArray(nums.size + 1)
    var count = 0
    sortedSum[0] = 0
    for (i in 1..nums.size) {
        sortedSum[i] = sortedSum[i - 1] + nums[i - 1].toLong()
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
            while (low <= end && sortedSum[low] - sortedSum[left] < lower) {
                low++
            }
            while (high <= end && sortedSum[high] - sortedSum[left] <= upper) {
                high++
            }
            while (right <= end && sortedSum[right] < sortedSum[left]) {
                sortingSpace[index++] = sortedSum[right++]
            }
            sortingSpace[index++] = sortedSum[left]
            count += high - low
        }
        while (right <= end) {
            sortingSpace[index++] = sortedSum[right++]
        }
        for (i in start..end) {
            sortedSum[i] = sortingSpace[i]
        }
    }
    mergesort(0, sortedSum.size - 1)
    return count
}


