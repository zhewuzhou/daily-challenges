package zhewuzhou.me.leetcode340

fun longestIncreasingPath(matrix: Array<IntArray>): Int {

    fun validCoordinate(r: Int, c: Int) =
        r in 0..matrix.lastIndex && c in 0..matrix[0].lastIndex

    fun doDfs(path: MutableList<Pair<Int, Int>>): Int {
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
            path.add(m)
            result = Math.max(doDfs(path), result)
            path.remove(path.last())
        }
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
