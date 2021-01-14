package zhewuzhou.me.daily

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class BattleshipsBoard419KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(
                    arrayOf(
                        charArrayOf('X', '.', '.', 'X'),
                        charArrayOf('.', '.', '.', 'X'),
                        charArrayOf('.', '.', '.', 'X')
                    ), 2
                ), Pair(
                    arrayOf(
                        charArrayOf('.', '.', '.', 'X'),
                        charArrayOf('X', 'X', 'X', 'X'),
                        charArrayOf('.', '.', '.', 'X')
                    ), 0
                ), Pair(
                    arrayOf(
                        charArrayOf('X', 'X', 'X', 'X')
                    ), 1
                ), Pair(
                    arrayOf(
                        charArrayOf('X', '.', '.', '.'),
                        charArrayOf('X', '.', '.', '.'),
                        charArrayOf('X', '.', '.', '.'),
                        charArrayOf('X', '.', '.', '.'),
                        charArrayOf('X', '.', '.', '.')
                    ), 1
                ), Pair(
                    arrayOf(
                        charArrayOf('X', '.', '.', '.')
                    ), 1
                ), Pair(
                    arrayOf(
                        charArrayOf('X', '.', '.', '.'),
                        charArrayOf('X', 'X', '.', '.')
                    ), 0
                ), Pair(
                    arrayOf(
                        charArrayOf('X', 'X', '.', '.'),
                        charArrayOf('.', 'X', '.', '.')
                    ), 0
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should count all of the battleships in the board`(case: Pair<Array<CharArray>, Int>) {
        assertThat(countBattleships(case.first), `is`(case.second))
    }
}