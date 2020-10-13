package zhewuzhou.me.leetcode180

fun findPeakElement(nums: IntArray): Int {
    if (nums.isEmpty()) return -1
    var low = 0
    var high = nums.lastIndex
    while (low < high) {
        val mid = (low + high) ushr 1
        if (nums[mid] > nums[mid + 1]) {
            high = mid
        } else {
            low = mid + 1
        }
    }
    return low
}
