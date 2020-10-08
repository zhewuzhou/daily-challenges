package zhewuzhou.me.dp

fun minimumTotalRecursive(triangle: List<List<Int>>): Int {
    if (triangle.isEmpty() || triangle.any { it.isEmpty() }) return 0
    val cache = mutableMapOf<Pair<Int, Int>, Int>()
    fun minimumTotalInternal(r: Int, c: Int): Int {
        val key = Pair(r, c)
        if (cache.containsKey(key)) return cache[key]!!
        var res = Int.MAX_VALUE
        if (r == 0) res = triangle[0][0]
        else {
            for (j in c - 1..c) {
                if (j in triangle[r - 1].indices) {
                    res = Math.min(res, minimumTotalInternal(r - 1, j) + triangle[r][c])
                }
            }
        }
        cache[key] = res
        return cache[key]!!
    }

    var min = Int.MAX_VALUE
    for (i in triangle.last().indices) {
        min = Math.min(minimumTotalInternal(triangle.lastIndex, i), min)
    }
    return min
}

fun minimumTotal(triangle: List<List<Int>>): Int {
    if (triangle.isEmpty() || triangle.any { it.isEmpty() }) return 0
    val height = triangle.size
    val maxWidth = triangle.last().size
    val matrix = Array(height) {
        IntArray(maxWidth)
    }
    for (i in triangle[0].indices) {
        matrix[0][i] = triangle[0][i]
    }
    for (i in 1 until height) {
        for (j in triangle[i].indices) {
            matrix[i][j] = when (j) {
                0 -> matrix[i - 1][j] + triangle[i][j]
                triangle[i].lastIndex -> matrix[i - 1][j - 1] + triangle[i][j]
                else -> {
                    Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]) + triangle[i][j]
                }
            }
        }
    }
    return matrix[matrix.lastIndex].min()!!
}
