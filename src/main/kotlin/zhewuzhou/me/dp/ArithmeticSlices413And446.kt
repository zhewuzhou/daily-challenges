package zhewuzhou.me.dp

fun numberOfArithmeticSlicesC(nums: IntArray): Int {
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
    for (i in 2..nums.lastIndex) {
        if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
            metrics[i] = metrics[i - 1] + 1
            total += metrics[i]
        }
    }
    return total
}

fun numberOfArithmeticSlices(nums: IntArray): Int {
    if (nums.size < 3) return 0
    val maxDiff = (nums.last() - nums[0]) / 2
    val metrics = Array(nums.size) {
        IntArray(maxDiff + 1)
    }
    var total = 0
    for (i in 2..metrics.lastIndex) {
        for (j in 1 until i) {
            for (k in 0 until j) {
                if (nums[i] - nums[j] == nums[j] - nums[k]) {
                    val diff = nums[i] - nums[j]
                    metrics[i][diff] += metrics[j][diff] + 1
                    total += metrics[i][diff]
                }
            }
        }
    }
    return total
}
