package zhewuzhou.me.numberssort

fun sortColors(nums: IntArray) {
    fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }

    var second = nums.lastIndex
    var zero = 0
    for (i in 0..second) {
        while (nums[i] == 2 && i < second) {
            swap(nums, i, second)
            second -= 1
        }
        while (nums[i] == 0 && i > zero) {
            swap(nums, i, zero)
            zero += 1
        }
    }
}
