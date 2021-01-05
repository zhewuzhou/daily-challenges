package zhewuzhou.me.daily

/**
 * Do not try to return value from DFS, it's making things much harder
 * Reverse or reduce the logic to make it simpler
 */
fun pacificAtlantic(matrix: Array<IntArray>): List<List<Int>> {
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return listOf()
    }
    val row = matrix.size
    val col = matrix[0].size
    val pacific = Array(row) {
        (BooleanArray(col))
    }
    val atlantic = Array(row) {
        (BooleanArray(col))
    }

    fun isValid(r: Int, c: Int): Boolean {
        return r in (0 until row) && c in (0 until col)
    }

    fun dfs(r: Int, c: Int, ocean: Array<BooleanArray>, preHeight: Int) {
        if (!isValid(r, c) || ocean[r][c] || matrix[r][c] < preHeight) {
            return
        }
        ocean[r][c] = true
        dfs(r + 1, c, ocean, matrix[r][c])
        dfs(r - 1, c, ocean, matrix[r][c])
        dfs(r, c + 1, ocean, matrix[r][c])
        dfs(r, c - 1, ocean, matrix[r][c])
    }

    for (r in 0 until row) {
        dfs(r, 0, pacific, matrix[r][0])
        dfs(r, col - 1, atlantic, matrix[r][col - 1])
    }

    for (c in 0 until col) {
        dfs(0, c, pacific, matrix[0][c])
        dfs(row - 1, c, atlantic, matrix[row - 1][c])
    }

    val result = mutableListOf<List<Int>>()
    for (r in 0 until row) {
        for (c in 0 until col) {
            if (pacific[r][c] && atlantic[r][c]) {
                result.add(listOf(r, c))
            }
        }
    }
    return result
}