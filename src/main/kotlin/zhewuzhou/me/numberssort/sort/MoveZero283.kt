package zhewuzhou.me.numberssort.sort

fun moveZeroes(nums: IntArray) {
    var leftMostZeroIndex = 0
    for (i in nums.indices) {
        if (nums[i] != 0) {
            if (i > leftMostZeroIndex) {
                nums[leftMostZeroIndex] = nums[i]
                nums[i] = 0
            }
            leftMostZeroIndex++
        }
    }
}

