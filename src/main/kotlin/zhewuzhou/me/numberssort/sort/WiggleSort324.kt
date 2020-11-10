package zhewuzhou.me.numberssort.sort

import zhewuzhou.utils.swap

fun wiggleSort(nums: IntArray) {
    val median = findKthLargest(nums, (nums.size + 1) / 2)
    val n = nums.size
    var left = 0
    var i = 0
    var right = n - 1
    while (i <= right) {
        when {
            nums[placeTo(i, n)] > median -> {
                nums.swap(placeTo(left++, n), placeTo(i++, n))
            }
            nums[placeTo(i, n)] < median -> {
                nums.swap(placeTo(right--, n), placeTo(i, n))
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
