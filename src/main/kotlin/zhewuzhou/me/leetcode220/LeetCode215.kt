package zhewuzhou.me.leetcode220


fun findKthLargest(nums: IntArray, k: Int): Int {
    return quickSelect(nums, 0, nums.lastIndex, k)
}

fun quickSelect(nums: IntArray, low: Int, high: Int, k: Int): Int {
    var pivot = low
    for (j in low until high) {
        if (nums[j] <= nums[high]) {
            swap(nums, pivot, j)
            pivot += 1
        }
    }
    swap(nums, pivot, high)
    val count = high - pivot + 1
    if (count == k) return nums[pivot]
    return if (count > k)
        quickSelect(nums, pivot + 1, high, k)
    else
        quickSelect(nums, low, pivot - 1, k - count)
}

private fun swap(nums: IntArray, i: Int, j: Int) {
    val t = nums[i]
    nums[i] = nums[j]
    nums[j] = t
}
