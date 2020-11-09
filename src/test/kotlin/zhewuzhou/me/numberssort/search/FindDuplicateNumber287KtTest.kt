package zhewuzhou.me.numberssort.search

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class FindDuplicateNumber287KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
                arrayOf(
                        Pair(intArrayOf(1, 3, 1, 2), 1),
                        Pair(intArrayOf(1, 3, 1, 3), 3),
                        Pair(intArrayOf(1, 1), 1),
                        Pair(intArrayOf(2), -1),
                        Pair(intArrayOf(), -1),
                        Pair(intArrayOf(1, 3, 2, 1, 4, 5), 1)
                )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find the duplicated element in array`(case: Pair<IntArray, Int>) {
        assertThat(findDuplicate(case.first), `is`(case.second))
    }
}