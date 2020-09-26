package zhewuzhou.me.numberssort

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class FirstMissingPositive41KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(intArrayOf(1, 2, 0), 3),
                Pair(intArrayOf(3, 4, -1, 1), 2),
                Pair(intArrayOf(7, 8, 9, 11, 12), 1),
                Pair(listOf((-10000..10000), (20000..30000)).flatMap { it.toList() }.toIntArray(), 10001),
                Pair(listOf((-10..10), (20..30)).flatMap { it.toList() }.toIntArray(), 11)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find the smallest positive number`(case: Pair<IntArray, Int>) {
        assertThat(firstMissingPositive(case.first), `is`(case.second))
    }
}
