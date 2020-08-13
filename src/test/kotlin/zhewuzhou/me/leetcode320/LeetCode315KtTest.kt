package zhewuzhou.me.leetcode320

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LeetCode315KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(intArrayOf(5, 2, 6, 1), listOf(2, 1, 1, 0))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find all smaller num from the given arr`(case: Pair<IntArray, List<Int>>) {
        assertThat(countSmaller(case.first), `is`(case.second))
    }
}
