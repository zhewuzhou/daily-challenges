package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class ArithmeticSlices413And446KtTest {
    private companion object {
        @JvmStatic
        fun continuousCase() = Arrays.stream(
            arrayOf(
                Pair(intArrayOf(1, 2, 3, 4), 3),
                Pair(intArrayOf(1, 2), 0),
                Pair(intArrayOf(1), 0),
                Pair(intArrayOf(), 0),
                Pair(intArrayOf(1, 3, 5, 7, 9, 11, 13), 15),
                Pair(intArrayOf(1, 3, 5, 7, 9, 11, 13, 15, 18, 21, 24, 26, 28, 30, 32), 30),
                Pair(intArrayOf(1, 3, 5, 7, 9, 15, 16, 18, 17), 6),
                Pair(intArrayOf(1, 3, 5, 7, 9, 11, 13, 15, 17), 28)
            )
        )

        @JvmStatic
        fun allCases() = Arrays.stream(
            arrayOf(
                Pair(intArrayOf(1, 2, 3, 4), 3),
                Pair(intArrayOf(1, 2), 0),
                Pair(intArrayOf(1), 0),
                Pair(intArrayOf(), 0),
                Pair(intArrayOf(1, 3, 5, 7, 9, 11, 13), 20),
                Pair(intArrayOf(1, 3, 5, 7, 9), 7)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("continuousCase")
    fun `Should return number of arithmetic slices`(case: Pair<IntArray, Int>) {
        assertThat(numberOfArithmeticSlicesDP(case.first), `is`(case.second))
    }

    @ParameterizedTest
    @MethodSource("allCases")
    fun `Should calculate all cases for given array`(case: Pair<IntArray, Int>) {
        assertThat(numberOfArithmeticSlices(case.first), `is`(case.second))
    }
}
