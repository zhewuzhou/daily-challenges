package zhewuzhou.me.leetcode60

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

class LeetCode45KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(intArrayOf(2, 3, 1, 1, 4), 2),
                Pair(intArrayOf(2, 3, 0, 1, 4), 2),
                Pair(intArrayOf(1, 2, 1, 1, 1), 3),
                Pair(intArrayOf(3, 2, 1, 0, 4), 6)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should jump minimal steps to end`(case: Pair<IntArray, Int>) {
        assertThat(jump(case.first), `is`(case.second))
    }
}
