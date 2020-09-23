package zhewuzhou.me.simple

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class TwoSum1KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(intArrayOf(2, 7, 11, 15), 9, listOf(0, 1)),
                Triple(intArrayOf(3, 3), 6, listOf(0, 1)),
                Triple(intArrayOf(3, 2, 4), 6, listOf(1, 2)),
                Triple(intArrayOf(-1, -2, -3, -4, -5), -8, listOf(2, 4))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find the 2 indexes for sum of target`(case: Triple<IntArray, Int, List<Int>>) {
        assertThat(twoSum(case.first, case.second).toList().sorted(), `is`(case.third.sorted()))
    }
}
