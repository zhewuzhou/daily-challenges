package zhewuzhou.me.leetcode140

/**
 * Don't understand why binary search works here
 */
fun superEggDropRecur(eggs: Int, levels: Int): Int {
    val caches = mutableMapOf<Pair<Int, Int>, Int>()
    fun drop(egg: Int, lev: Int): Int {
        val key = Pair(egg, lev)
        if (caches.containsKey(key)) return caches[key]!!
        var res = lev
        when {
            egg == 1 -> res = lev
            (lev == 1 || lev == 0) -> res = 1
            else -> {
                var start = 1
                var end = lev
                while (start <= end) {
                    var curMax = 0
                    val mid = (start + end) / 2
                    val broken = drop(egg - 1, mid - 1)
                    val intact = drop(egg, lev - mid)
                    curMax = Math.max(broken, intact) + 1
                    if (broken < intact) {
                        start = mid + 1
                    } else {
                        end = mid - 1
                    }
                    res = Math.min(res, curMax)
                }
            }
        }
        caches[key] = res
        return caches[key]!!
    }
    return drop(eggs, levels)
}

/**
 * TLE solution which means the selection of K is not effective enough
 */
fun superEggDrop(eggs: Int, levels: Int): Int {
    val drop = Array(levels + 1) { IntArray(eggs + 1) }
    var m = 0
    while (drop[m][eggs] < levels) {
        m += 1
        for (k in 1..eggs) drop[m][k] = drop[m - 1][k - 1] + drop[m - 1][k] + 1
    }
    return m
}

/**
 * Math solution :)
 */

fun superEggDropMath(eggs: Int, levels: Int): Int {
    val cache = mutableMapOf<Int, Int>()
    fun calculate(curLevel: Int): Int {
        if (cache.containsKey(curLevel)) return cache[curLevel]!!
        var res = 0
        var r = 1
        for (i in 1..eggs) {
            r *= (curLevel - i + 1)
            r /= i
            res += r
            if (res > levels) break
        }
        cache[curLevel] = res
        return cache[curLevel]!!
    }

    var start = 1
    var end = levels
    while (start < end) {
        val mid = (start + end) / 2
        if (calculate(mid) < levels) {
            start = mid + 1
        } else {
            end = mid
        }
    }
    return start
}
