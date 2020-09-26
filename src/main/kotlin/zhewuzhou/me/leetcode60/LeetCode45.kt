package zhewuzhou.me.leetcode60

fun jump(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    val steps = IntArray(nums.size)
    for (i in (nums.size - 2) downTo 0) {
        when (nums[i] >= nums.lastIndex - i) {
            true -> steps[i] = 1
            false -> {
                var minSteps = nums.size + 1
                for (j in (i + 1)..(i + nums[i])) {
                    minSteps = Math.min((1 + steps[j]), minSteps)
                }
                steps[i] = minSteps
            }
        }
    }
    return steps[0]
}

fun jumpRecursiveNotWorks(nums: IntArray): Int {
    tailrec fun recursiveJump(first: Int, last: Int, additional: Int): Int {
        if (nums.size - 1 <= last) {
            return additional
        }

        var max = 0
        for (index in first..last) {
            max = Math.max(max, index + (nums[index]))
        }
        return recursiveJump(last, max, additional + 1)
    }
    if (nums.size == 1) return 0
    return recursiveJump(1, nums[0], 1)
}
