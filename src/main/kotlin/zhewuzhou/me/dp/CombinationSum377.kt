package zhewuzhou.me.dp

fun combinationSum4Recur(nums: IntArray, target: Int): Int {
    nums.sort()
    val caches = mutableMapOf<Int, Int>()
    fun combinations(t: Int): Int {
        if (caches.containsKey(t)) return caches[t]!!
        if (t == 0) return 1
        var result = 0
        for (i in nums.indices) {
            if (t >= nums[i]) {
                result += combinations(t - nums[i])
            }
        }
        caches[t] = result
        return result
    }
    return combinations(target)
}

fun combinationSum4(nums: IntArray, target: Int): Int {
    nums.sort()
    val result = IntArray(target + 1)
    result[0] = 1
    for (i in 1..target) {
        for (j in nums) {
            if (i >= j) {
                result[i] += result[i - j]
            }
        }
    }
    return result[target]
}
