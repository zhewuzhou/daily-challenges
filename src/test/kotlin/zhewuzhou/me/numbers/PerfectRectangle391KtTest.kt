package zhewuzhou.me.numbers

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

/*
1. N rectangles such that N>0
2. If N rectangles form exact one rectangle
    - Can not overlap
    - Exact!!!
 */

internal class PerfectRectangle391KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(arrayOf(intArrayOf(1, 1, 3, 3), intArrayOf(3, 1, 4, 2),
                    intArrayOf(3, 2, 4, 4), intArrayOf(1, 3, 2, 4), intArrayOf(2, 3, 3, 4)), true),
                Pair(arrayOf(intArrayOf(1, 1, 2, 3), intArrayOf(1, 3, 2, 4),
                    intArrayOf(3, 1, 4, 2), intArrayOf(3, 2, 4, 4)), false),
                Pair(arrayOf(intArrayOf(1, 1, 3, 3), intArrayOf(3, 1, 4, 2),
                    intArrayOf(1, 3, 2, 4), intArrayOf(3, 2, 4, 4)), false),
                Pair(arrayOf(intArrayOf(1, 1, 3, 3), intArrayOf(3, 1, 4, 2),
                    intArrayOf(1, 3, 2, 4), intArrayOf(2, 2, 4, 4)), false)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should determine if there is perfect rectangle`(case: Pair<Array<IntArray>, Boolean>) {
        assertThat(isRectangleCover(case.first), `is`(case.second))
    }
}
