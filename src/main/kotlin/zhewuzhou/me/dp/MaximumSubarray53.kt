package zhewuzhou.me.dp

fun maxSubArray(nums: IntArray): Int {
    val dp = IntArray(nums.size)
    dp[0] = nums[0]
    var maxSub = dp[0]
    for (i in 1..nums.lastIndex) {
        dp[i] = nums[i] + Math.max(dp[i - 1], 0)
        maxSub = Math.max(maxSub, dp[i])
    }
    return maxSub
}
