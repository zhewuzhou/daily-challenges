package zhewuzhou.me.dp.typical

fun climbStairsRecur(n: Int): Int {
    // base cases
    if (n <= 0) return 0
    if (n == 1) return 1
    if (n == 2) return 2
    var oneStepBefore = 2
    var twoStepsBefore = 1
    var allWays = 0
    for (i in 2 until n) {
        allWays = oneStepBefore + twoStepsBefore
        twoStepsBefore = oneStepBefore
        oneStepBefore = allWays
    }
    return allWays
}

fun climbStairs(n: Int): Int {
    val cache = mutableMapOf<Int, Int>()
    fun climb(target: Int): Int {
        if (cache.containsKey(target)) {
            return cache[target]!!
        }
        val res = when (target) {
            1 -> 1
            2 -> 2
            else -> climb(target - 1) + climb(target - 2)
        }
        cache[target] = res
        return cache[target]!!
    }
    return climb(n)
}


