package zhewuzhou.me.leetcode140

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

fun superEggDrop(eggs: Int, levels: Int): Int {
    val throws = Array(eggs + 1) { IntArray(levels + 1) }
    for (i in 1..levels) {
        throws[1][i] = i
    }
    for (i in 1..eggs) {
        throws[i][1] = 1
    }
    for (i in 2..eggs) {
        for (j in 2..levels) {
            var minTries = j
            for (k in 1 until j) {
                val p = Math.max(throws[i - 1][k - 1], throws[i][j - k]) + 1
                minTries = Math.min(minTries, p)
            }
            throws[i][j] = minTries
        }
    }
    return throws[eggs][levels]
}
