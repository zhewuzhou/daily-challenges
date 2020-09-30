package zhewuzhou.me.numberssort

import zhewuzhou.utils.swap

fun sortColors(nums: IntArray) {
    var second = nums.lastIndex
    var zero = 0
    for (i in 0..second) {
        while (nums[i] == 2 && i < second) {
            nums.swap(i, second)
            second -= 1
        }
        while (nums[i] == 0 && i > zero) {
            nums.swap(i, zero)
            zero += 1
        }
    }
}
