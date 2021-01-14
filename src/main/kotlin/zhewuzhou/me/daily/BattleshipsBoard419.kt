package zhewuzhou.me.daily

/**
 * When There is **|
 *                *| no mater vertically or horizontally is both invalid
 * Valid & Count can be separated
 */
fun countBattleships(board: Array<CharArray>): Int {
    if (board.isEmpty() || board[0].isEmpty()) return -1
    var total = 0
    for (i in board.indices) {
        for (j in board[0].indices) {
            if (board[i][j] == 'X') {
                if (i > 0 && board[i - 1][j] == 'X') {
                    if (j > 0 && board[i - 1][j - 1] == 'X' ||
                        j < board[0].lastIndex && board[i - 1][j + 1] == 'X'
                    ) {
                        return 0
                    }
                } else {
                    when {
                        j > 0 && i > 0 && board[i][j - 1] == 'X' && board[i - 1][j - 1] == 'X' -> return 0
                        j == 0 || board[i][j - 1] != 'X' -> total += 1
                    }
                }
            }
        }
    }
    return total
}