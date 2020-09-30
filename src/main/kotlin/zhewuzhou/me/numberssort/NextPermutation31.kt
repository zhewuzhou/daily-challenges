package zhewuzhou.me.numberssort

import zhewuzhou.utils.swap

fun nextPermutation(nums: IntArray): Unit {
    if (nums.isEmpty() || nums.size == 1) return
    val zipWithNext = nums.toList().zipWithNext()
    val descendingOrder = zipWithNext.all { it.first >= it.second }
    if (descendingOrder) {
        nums.reverse()
        return
    }
    var i = nums.size - 2
    var j = nums.size - 1
    while (nums[i] >= nums[i + 1]) i -= 1
    while (nums[j] <= nums[i]) j -= 1
    nums.swap(i, j)
    reverse(nums, i + 1)
}

fun reverse(nums: IntArray, start: Int) {
    var e = nums.size - 1
    var s = start
    while (s < e) {
        nums.swap(s, e)
        s += 1
        e -= 1
    }
}
