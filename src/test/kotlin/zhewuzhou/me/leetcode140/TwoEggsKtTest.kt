package zhewuzhou.me.leetcode140

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class TwoEggsKtTest {
    private companion object {
        @JvmStatic
        fun eggCases() = Arrays.stream(
            arrayOf(
                Triple(1, 100, 100),
                Triple(2, 100, 14),
                Triple(3, 100, 9),
                Triple(4, 100, 8),
                Triple(5, 100, 7),
                Triple(20, 100, 7),
                Triple(200, 100, 7),
                Triple(1, 2, 2),
                Triple(2, 6, 3),
                Triple(3, 14, 4),
                Triple(4, 1000, 13)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("eggCases")
    fun `Throw egg problem solve with DP`(case: Triple<Int, Int, Int>) {
        assertThat(superEggDrop(case.first, case.second), `is`(case.third))
        assertThat(superEggDropRecur(case.first, case.second), `is`(case.third))
    }
}
