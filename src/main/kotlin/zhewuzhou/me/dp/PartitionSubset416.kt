package zhewuzhou.me.dp

/*
Recursion: Choose or not choose for every element form 2^n solution space
 */

fun canPartitionRecur(nums: IntArray): Boolean {
    if (nums.isEmpty() || nums.size < 2) return false
    var sum = nums.sum()
    if (sum.and(1) == 1) return false
    sum /= 2
    fun partition(index: Int, sum: Int): Boolean {
        if (sum == 0) return true
        if (index >= nums.size) return false
        return partition(index + 1, sum) || partition(index + 1, sum - nums[index])
    }
    return partition(0, sum)
}
