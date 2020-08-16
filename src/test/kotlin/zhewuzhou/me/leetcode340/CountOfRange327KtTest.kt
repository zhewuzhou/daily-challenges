package zhewuzhou.me.leetcode340

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class CountOfRange327KtTest {
    data class CountOfRangeCase(val nums: List<Int>,
                                val lower: Int,
                                val upper: Int,
                                val expected: Int
    )

    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                CountOfRangeCase(listOf(-2, 5, -1), -2, 2, 3)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find the num of the sum of range`(case: CountOfRangeCase) {
        assertThat(countRangeSum(case.nums.toIntArray(), case.lower, case.upper), `is`(case.expected))
    }
}
