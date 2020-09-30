package zhewuzhou.me.numberssort

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class SortColors75KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(intArrayOf(2, 0, 2, 1, 1, 0), listOf(0, 0, 1, 1, 2, 2)),
                Pair(intArrayOf(2, 0, 1), listOf(0, 1, 2)),
                Pair(intArrayOf(0), listOf(0)),
                Pair(intArrayOf(1), listOf(1))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should sort colors`(case: Pair<IntArray, List<Int>>) {
        val result = case.first
        val expect = case.second
        sortColors(result)
        assertThat(result.toList(), `is`(case.second))
    }
}
