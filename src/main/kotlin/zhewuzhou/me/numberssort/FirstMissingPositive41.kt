package zhewuzhou.me.numberssort

import zhewuzhou.utils.swap

/*
    Try it with small numbers, get some hints
 */
fun firstMissingPositive(nums: IntArray): Int {
    if (nums.isEmpty()) return 1
    for (i in nums.indices) {
        while (nums[i] > 0 && nums[i] < nums.size && nums[i] != nums[nums[i] - 1]) {
            nums.swap(i, nums[i] - 1)
        }
    }
    for (i in nums.indices) {
        if (nums[i] != i + 1) {
            return i + 1
        }
    }
    return nums.size + 1
}
