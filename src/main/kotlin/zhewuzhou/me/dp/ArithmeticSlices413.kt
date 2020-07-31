package zhewuzhou.me.dp

fun numberOfArithmeticSlices(nums: IntArray): Int {
    var cur = 2
    var curMaxLen = 2
    var total = 0
    while (cur < nums.size) {
        if (nums[cur] - nums[cur - 1] == nums[cur - 1] - nums[cur - 2]) {
            curMaxLen += 1
        } else {
            if (curMaxLen != 2) {
                total += (curMaxLen - 2) * (curMaxLen - 1) / 2
                curMaxLen = 2
            }
        }
        cur += 1
    }
    if (curMaxLen > 2) total += (curMaxLen - 2) * (curMaxLen - 1) / 2
    return total
}

fun numberOfArithmeticSlicesDP(nums: IntArray): Int {
    if (nums.size < 3) return 0
    val metrics = IntArray(nums.size)
    var total = 0
    if (nums[2] - nums[1] == nums[1] - nums[0]) {
        metrics[2] = 1
        total += 1
    }
    for (i in 3..nums.lastIndex) {
        if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
            metrics[i] = metrics[i - 1] + 1
            total += metrics[i]
        }
    }
    return total
}
