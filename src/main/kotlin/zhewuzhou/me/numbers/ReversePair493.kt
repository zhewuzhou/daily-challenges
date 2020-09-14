package zhewuzhou.me.numbers

fun reversePairs(nums: IntArray): Int {
    var res = 0
    for (i in nums.indices) {
        for (j in i + 1..nums.lastIndex) {
            if (nums[i] > 2 * nums[j]) {
                res += 1
            }
        }
    }
    return res
}
