package zhewuzhou.me.numberssort.matrix

fun gameOfLife(board: Array<IntArray>): Unit {
    if (board.isEmpty() ||
        board[0].isEmpty() ||
        board.any { line -> line.any { it < 0 || it > 1 } })
        return
    for (r in board.indices) {
        for (c in board[0].indices) {
            var liveNeighbors = -board[r][c]
            for (i in r - 1..r + 1) {
                for (j in c - 1..c + 1) {
                    if (i in board.indices &&
                        j in board[0].indices &&
                        board[i][j].and(1) == 1) {
                        liveNeighbors += 1
                    }
                }
            }
            if (board[r][c] == 1 && liveNeighbors in 2..3) board[r][c] = 3
            if (board[r][c] == 0 && liveNeighbors == 3) board[r][c] = 2
        }
    }
    for (r in board.indices) {
        for (c in board[0].indices) {
            board[r][c] = board[r][c].shr(1)
        }
    }
}
