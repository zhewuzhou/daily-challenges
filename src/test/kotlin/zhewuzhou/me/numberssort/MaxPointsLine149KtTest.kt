package zhewuzhou.me.numberssort

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.me.leetcode160.maxPoints
import java.util.*

internal class MaxPointsLine149KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(listOf(listOf(1, 1), listOf(2, 2), listOf(3, 3)), 3),
                Pair(listOf(listOf(1, 1), listOf(3, 2), listOf(5, 3), listOf(4, 1), listOf(2, 3), listOf(1, 4)), 4),
                Pair(listOf(listOf(1, 1), listOf(1, 1), listOf(2, 2), listOf(2, 2)), 4),
                Pair(listOf(listOf(1, 1), listOf(1, 1), listOf(1, 1), listOf(1, 1)), 4),
                Pair(listOf(listOf(0, 0), listOf(94911151, 94911150), listOf(94911152, 94911151), listOf(1, 1)), 2)

            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate max points num that lay on the same line`(case: Pair<List<List<Int>>, Int>) {
        val input = case.first.map { it.toIntArray() }.toTypedArray()
        assertThat(maxPoints(input), `is`(case.second))
    }
}
