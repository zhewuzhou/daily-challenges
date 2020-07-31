package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class ArithmeticSlices413KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(intArrayOf(1, 2, 3, 4), 3),
                Pair(intArrayOf(1, 2), 0),
                Pair(intArrayOf(1), 0),
                Pair(intArrayOf(), 0),
                Pair(intArrayOf(1, 3, 5, 7, 9, 15, 16, 18, 17), 6),
                Pair(intArrayOf(1, 3, 5, 7, 9, 11, 13, 15, 18, 21, 24, 26, 28, 30, 32), 30)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should return number of arithmetic slices`(case: Pair<IntArray, Int>) {
        assertThat(numberOfArithmeticSlicesDP(case.first), `is`(case.second))
    }
}
