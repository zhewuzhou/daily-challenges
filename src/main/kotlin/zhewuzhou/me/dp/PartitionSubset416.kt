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

fun canPartition(nums: IntArray): Boolean {
    if (nums.isEmpty() || nums.size < 2) return false
    var sum = nums.sum()
    if (sum.and(1) == 1) return false
    sum /= 2
    val metrics = Array(nums.size + 1) {
        BooleanArray(sum + 1) {
            false
        }
    }
    for (i in 1..metrics.lastIndex) {
        metrics[i][0] = true
    }
    metrics[0][0] = true
    for (i in 1..metrics.lastIndex) {
        for (j in 1..metrics[0].lastIndex) {
            metrics[i][j] = metrics[i - 1][j]
            if (j >= nums[i - 1]) {
                metrics[i][j] = (metrics[i][j] || metrics[i - 1][j - nums[i - 1]])
            }
        }
    }
    return metrics[nums.lastIndex][sum]
}
