package zhewuzhou.me.leetcode340

import zhewuzhou.me.leetcode220.findKthLargest

fun wiggleSort(nums: IntArray) {
    val median = findKthLargest(nums, (nums.size + 1) / 2)
    val n = nums.size
    var left = 0
    var i = 0
    var right = n - 1
    while (i <= right) {
        when {
            nums[placeTo(i, n)] > median -> {
                swap(nums, placeTo(left++, n), placeTo(i++, n))
            }
            nums[placeTo(i, n)] < median -> {
                swap(nums, placeTo(right--, n), placeTo(i, n))
            }
            else -> {
                i++
            }
        }
    }
}

private fun placeTo(index: Int, n: Int): Int {
    return (1 + 2 * index) % (n.or(1))
}

private fun swap(nums: IntArray, i: Int, j: Int) {
    val t = nums[i]
    nums[i] = nums[j]
    nums[j] = t
}
