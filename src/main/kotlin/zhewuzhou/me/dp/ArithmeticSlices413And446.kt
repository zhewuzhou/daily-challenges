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
    var total = 0
    val metrics = Array(nums.size) {
        mutableMapOf<Int, Int>()
    }
    for (i in nums.indices) {
        for (j in 0 until i) {
            val diff = nums[i].toLong() - nums[j].toLong()
            if (diff <= Int.MIN_VALUE || diff > Int.MAX_VALUE) continue
            val d = diff.toInt()
            val current = metrics[i].getOrDefault(d, 0)
            val pre = metrics[j].getOrDefault(d, 0)
            total += pre
            metrics[i][d] = current + pre + 1
        }
    }
    return total
}
