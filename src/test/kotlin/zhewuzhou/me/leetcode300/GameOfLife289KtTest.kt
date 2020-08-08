package zhewuzhou.me.leetcode300

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class GameOfLife289KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(arrayOf(intArrayOf(0, 1, 0), intArrayOf(0, 0, 1), intArrayOf(1, 1, 1), intArrayOf(0, 0, 0)),
                    arrayOf(intArrayOf(0, 0, 0), intArrayOf(1, 0, 1), intArrayOf(0, 1, 1), intArrayOf(0, 1, 0)))
            )
        )
    }

    /*

     */
    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate life game`(case: Pair<Array<IntArray>, Array<IntArray>>) {
        val board = case.first
        gameOfLife(board)
        for (i in board.indices) {
            for (j in board[0].indices) {
                assertThat(board[i][j], `is`(case.second[i][j]))
            }
        }
    }
}
