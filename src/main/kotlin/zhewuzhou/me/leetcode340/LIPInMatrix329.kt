package zhewuzhou.me.leetcode340

fun longestIncreasingPath(matrix: Array<IntArray>): Int {
    if (matrix.isEmpty() || matrix[0].isEmpty()) return 0
    val caches = mutableMapOf<Pair<Int, Int>, Int>()

    fun validCoordinate(r: Int, c: Int) =
        r in 0..matrix.lastIndex && c in 0..matrix[0].lastIndex

    fun doDfs(path: MutableList<Pair<Int, Int>>): Int {
        if (caches.containsKey(path.first())) return caches[path.first()]!!
        val cur = path.last()
        val possibleMoves = listOf(
            Pair(cur.first - 1, cur.second),
            Pair(cur.first + 1, cur.second),
            Pair(cur.first, cur.second - 1),
            Pair(cur.first, cur.second + 1)
        ).filter {
            validCoordinate(it.first, it.second) &&
                !path.contains(it) &&
                matrix[it.first][it.second] > matrix[cur.first][cur.second]
        }
        if (possibleMoves.isEmpty()) {
            return path.size
        }
        var result = 1
        for (m in possibleMoves) {
            result = Math.max(doDfs(mutableListOf(m)) + path.size, result)
        }
        caches[path.first()] = result
        return result
    }

    var res = 1
    for (i in 0..matrix.lastIndex) {
        for (j in 0..matrix[0].lastIndex) {
            res = Math.max(res, doDfs(mutableListOf(Pair(i, j))))
        }
    }
    return res
}
