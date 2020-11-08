package zhewuzhou.me.numberssort.search

import zhewuzhou.utils.swap

fun missingNumber(nums: IntArray): Int {
    for (i in nums.indices) {
        while (nums[i] <= nums.lastIndex && nums[i] != i) {
            nums.swap(i, nums[i])
        }
    }
    for (i in nums.indices) {
        if (i != nums[i]) {
            return i
        }
    }
    return -1
}
