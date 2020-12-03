package zhewuzhou.me.dp

fun calculateMinimumHP(dungeon: Array<IntArray>): Int {
    if (dungeon.isEmpty() || dungeon[0].isEmpty()) return 0
    val r = dungeon.size
    val c = dungeon[0].size
    val result = Array(r + 1) {
        IntArray(c + 1) {
            Int.MAX_VALUE
        }
    }
    result[r][c - 1] = 1
    for (i in r - 1 downTo 0) {
        for (j in c - 1 downTo 0) {
            val minNeighbour = Math.min(result[i + 1][j], result[i][j + 1])
            val need = minNeighbour - dungeon[i][j]
            result[i][j] = if (need <= 0) 1 else need
        }
    }
    return result[0][0]
}

fun calculateMinimumHPRecur(d: Array<IntArray>): Int {
    if (d.isEmpty() || d[0].isEmpty()) return 0
    val row = d.size
    val col = d[0].size
    val cache = mutableMapOf<Pair<Int, Int>, Int>()

    fun minNeedWhenStartAt(r: Int, c: Int): Int {
        val key = Pair(r, c)
        if (cache.containsKey(key)) {
            return cache[key]!!
        }
        val result = when {
            r == row || c == col -> {
                Int.MAX_VALUE
            }
            r == row - 1 && c == col - 1 -> {
                Math.max(1, -d[r][c] + 1)
            }
            else -> {
                val down = minNeedWhenStartAt(r + 1, c)
                val right = minNeedWhenStartAt(r, c + 1)
                Math.min(down, right) - d[r][c]
            }
        }
        cache[key] = if (result <= 0) 1 else result
        return cache[key]!!
    }
    return minNeedWhenStartAt(0, 0)
}
