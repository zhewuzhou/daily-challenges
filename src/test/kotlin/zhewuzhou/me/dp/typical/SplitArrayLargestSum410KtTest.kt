package zhewuzhou.me.dp.typical

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class SplitArrayLargestSum410KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
                arrayOf(
                        Triple(intArrayOf(7, 2, 5, 10, 8), 2, 18),
                        Triple(intArrayOf(1, 4, 4), 3, 4),
                        Triple((1..1000).toList().toIntArray(), 50, 10361)
                )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should cut the array to minimize the sum among the sub arrays`(case: Triple<IntArray, Int, Int>) {
        assertThat(splitArray(case.first, case.second), `is`(case.third))
    }
}