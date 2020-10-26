package zhewuzhou.me.slidingwindow

fun minSubArrayLen(target: Int, nums: IntArray): Int {
    if (nums.isEmpty()) {
        return 0
    }
    var right = 0
    var left = 0
    var min = Int.MAX_VALUE
    var sum = 0
    while (right < nums.size) {
        sum += nums[right]
        right += 1
        while (sum >= target) {
            min = Math.min(min, right - left)
            sum -= nums[left]
            left += 1
        }
    }
    return if (min == Int.MAX_VALUE) 0 else min
}
