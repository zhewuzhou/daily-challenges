package zhewuzhou.me.leetcode340

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class TopK347KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(intArrayOf(1, 1, 1, 2, 2, 3), 2, listOf(1, 2)),
                Triple(intArrayOf(1), 1, listOf(1)),
                Triple(intArrayOf(), 0, listOf()),
                Triple(intArrayOf(1, 1, 1, 1, 2, 2, 3, 3, 1, 1, 3, 3, 3, 2, 2), 2, listOf(1, 3))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate top k elements`(case: Triple<IntArray, Int, List<Int>>) {
        assertThat(topKFrequent(case.first, case.second).toList().sorted(), `is`(case.third))
    }
}
