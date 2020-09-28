package zhewuzhou.me.backtracing

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.me.backtracing.solveNQueens
import java.util.*

internal class NQueens51KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(4, 2),
                Pair(8, 92)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should solve n queue`(case: Pair<Int, Int>) {
        assertThat(solveNQueens(case.first).size, `is`(case.second))
    }
}
