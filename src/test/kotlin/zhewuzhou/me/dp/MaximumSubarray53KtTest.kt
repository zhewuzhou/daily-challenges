package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class MaximumSubarray53KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4), 6),
                Pair(intArrayOf(0), 0),
                Pair(intArrayOf(1), 1),
                Pair(intArrayOf(-1), -1),
                Pair(intArrayOf(-2147483647), -2147483647)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find the max sub array`(case: Pair<IntArray, Int>) {
        assertThat(maxSubArray(case.first), `is`(case.second))
    }
}
