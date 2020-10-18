package zhewuzhou.me.datastructure


fun numIslands(grid: Array<CharArray>): Int {
    if (grid.isEmpty() || grid[0].isEmpty()) return 0
    val uf = UF(grid.size * grid[0].size)
    val columnSize = grid[0].size
    var zeros = 0
    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (grid[i][j] == '1') {
                if (i > 0 && grid[i - 1][j] == '1') {
                    uf.union(i * columnSize + j, (i - 1) * columnSize + j)
                }
                if (j > 0 && grid[i][j - 1] == '1') {
                    uf.union(i * columnSize + j, i * columnSize + j - 1)
                }
            } else {
                zeros += 1
            }
        }
    }
    return uf.count() - zeros
}
