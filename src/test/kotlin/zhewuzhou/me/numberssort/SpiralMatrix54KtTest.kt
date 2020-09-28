package zhewuzhou.me.numberssort

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

class SpiralMatrix54KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6),
                    intArrayOf(7, 8, 9)
                ), listOf(1, 2, 3, 6, 9, 8, 7, 4, 5)),
                Pair(arrayOf(
                    intArrayOf(1, 2, 3, 4),
                    intArrayOf(5, 6, 7, 8),
                    intArrayOf(9, 10, 11, 12)
                ), listOf(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find the spiral order of matrix`(case: Pair<Array<IntArray>, List<Int>>) {
        assertThat(spiralOrder(case.first), `is`(case.second))
    }
}
