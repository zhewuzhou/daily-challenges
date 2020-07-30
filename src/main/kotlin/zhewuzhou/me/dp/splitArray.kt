package zhewuzhou.me.dp
/*
1 ≤ n ≤ 1000
1 ≤ m ≤ min(50, n)
 */

fun splitArray(nums: IntArray, m: Int): Int {
    val sum = IntArray(nums.size)
    sum[0] = nums[0]
    for (i in 1..nums.lastIndex) {
        sum[i] = sum[i - 1] + nums[i]
    }
    val cache = Array(nums.size) { IntArray(m + 1) { Int.MIN_VALUE } }

    fun split(upper: Int, k: Int): Int {
        if (cache[upper][k] != Int.MIN_VALUE) return cache[upper][k]
        if (k == 1) return sum[upper]
        var result = Int.MAX_VALUE
        for (i in k - 2 until upper) {
            result = Math.min(Math.max(split(i, k - 1), sum[upper] - sum[i]), result)
        }
        cache[upper][k] = result
        return cache[upper][k]
    }
    return split(nums.lastIndex, m)
}
