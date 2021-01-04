package zhewuzhou.me.daily

fun pacificAtlantic(matrix: Array<IntArray>): List<List<Int>> {
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return listOf()
    }

    val result = mutableListOf<List<Int>>()
    val pacificCache = mutableSetOf(
        Pair(0, matrix[0].lastIndex),
        Pair(matrix.lastIndex, 0)
    )

    val atlanticCache = mutableSetOf(
        Pair(0, matrix[0].lastIndex),
        Pair(matrix.lastIndex, 0)
    )

    fun nextSteps(cur: Pair<Int, Int>, visited: List<Pair<Int, Int>>): List<Pair<Int, Int>> {
        return listOf(
            Pair(cur.first + 1, cur.second),
            Pair(cur.first - 1, cur.second),
            Pair(cur.first, cur.second + 1),
            Pair(cur.first, cur.second - 1)
        ).filter {
            it.first in (0..matrix.lastIndex) &&
                    it.second in (0..matrix[0].lastIndex) &&
                    matrix[cur.first][cur.second] >= matrix[it.first][it.second] &&
                    !visited.contains(it)
        }
    }

    fun canMoveToPacific(grid: Pair<Int, Int>, visited: MutableList<Pair<Int, Int>>): Boolean {
        if (pacificCache.contains(grid) ||
            grid.first == 0 ||
            grid.second == 0
        ) {
            visited.add(grid)
            pacificCache.addAll(visited)
            return true
        } else {
            for (g in nextSteps(grid, visited)) {
                visited.add(g)
                if (canMoveToPacific(g, visited)) {
                    return true
                }
                visited.removeAt(visited.lastIndex)
            }
        }
        return false
    }

    fun canMoveToAtlantic(grid: Pair<Int, Int>, visited: MutableList<Pair<Int, Int>>): Boolean {
        if (atlanticCache.contains(grid) ||
            grid.first == matrix.lastIndex ||
            grid.second == matrix[0].lastIndex
        ) {
            visited.add(grid)
            atlanticCache.addAll(visited)
            return true
        } else {
            for (g in nextSteps(grid, visited)) {
                visited.add(g)
                if (canMoveToAtlantic(g, visited)) {
                    return true
                }
                visited.removeAt(visited.lastIndex)
            }
        }
        return false
    }

    for (r in 0..matrix.lastIndex) {
        for (c in 0..matrix[0].lastIndex) {
            val grid = Pair(r, c)
            if (canMoveToAtlantic(grid, mutableListOf()) && canMoveToPacific(grid, mutableListOf())) {
                result.add(listOf(r, c))
            }
        }
    }
    return result.toList()
}