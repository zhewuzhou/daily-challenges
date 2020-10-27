package zhewuzhou.me.numberssort.sort

import zhewuzhou.utils.swap


fun findKthLargest(nums: IntArray, k: Int): Int {
    return quickSelect(nums, 0, nums.lastIndex, k)
}

fun quickSelect(nums: IntArray, low: Int, high: Int, k: Int): Int {
    var pivot = low
    for (j in low until high) {
        if (nums[j] <= nums[high]) {
            nums.swap(pivot, j)
            pivot += 1
        }
    }
    nums.swap(pivot, high)
    val count = high - pivot + 1
    if (count == k) return nums[pivot]
    return if (count > k)
        quickSelect(nums, pivot + 1, high, k)
    else
        quickSelect(nums, low, pivot - 1, k - count)
}
