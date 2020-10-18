package zhewuzhou.me.datastructure

fun solve(board: Array<CharArray>) {
    if (board.isEmpty() || board[0].isEmpty()) return
    val columnSize = board[0].size
    val rowSize = board.size
    val uf = UF(columnSize * rowSize)
    val boundary = mutableListOf<Int>()
    for (i in board.indices) {
        for (j in board[0].indices) {
            if (board[i][j] == 'O') {
                if (j >= 1 && board[i][j - 1] == 'O') uf.union(indexInArray(i, j, columnSize), indexInArray(i, j - 1, columnSize))
                if (i >= 1 && board[i - 1][j] == 'O') uf.union(indexInArray(i, j, columnSize), indexInArray(i - 1, j, columnSize))
                if (i == 0 || i == rowSize - 1 || j == 0 || j == columnSize - 1) {
                    boundary.add(indexInArray(i, j, columnSize))
                }
            }
        }
    }
    for (i in board.indices) {
        for (j in board[0].indices) {
            if (board[i][j] == 'O') {
                if (boundary.any { uf.connected(it, indexInArray(i, j, columnSize)) }) {
                    continue
                } else {
                    board[i][j] = 'X'
                }
            }
        }
    }
}

private fun indexInArray(i: Int, j: Int, columnSize: Int) = i * columnSize + j
