package zhewuzhou.me.dp

fun canJump(nums: IntArray): Boolean {
    if (nums.isEmpty()) return true
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
    return steps[0] < nums.size
}

fun jump(nums: IntArray): Int {
    var steps = 0
    var end = 0
    var start = 0
    var maxEnd = 0
    while (end < nums.lastIndex) {
        steps += 1
        maxEnd = end + 1
        for (i in start..end) {
            if (i + nums[i] > nums.lastIndex) return steps
            maxEnd = Math.max(maxEnd, i + nums[i])
        }
        start = end + 1
        end = maxEnd
    }
    return steps
}
