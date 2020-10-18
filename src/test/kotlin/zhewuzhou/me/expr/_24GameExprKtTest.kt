package zhewuzhou.me.expr

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class _24GameExprKtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(intArrayOf(4, 1, 8, 7), 24),
                Pair(intArrayOf(3, 8, 3, 8), 4),
                Pair(intArrayOf(6, 6, 6, 6), 42)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate possible paths`(case: Pair<IntArray, Int>) {
        assertThat(point24Expr(case.first).size, `is`(case.second))
    }
}
