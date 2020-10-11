package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.me.leetcode140.superEggDrop
import zhewuzhou.me.leetcode140.superEggDropMath
import zhewuzhou.me.leetcode140.superEggDropRecur
import java.util.*

internal class SuperEggDrop887KtTest {
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
        MatcherAssert.assertThat(superEggDrop(case.first, case.second), CoreMatchers.`is`(case.third))
        MatcherAssert.assertThat(superEggDropMath(case.first, case.second), CoreMatchers.`is`(case.third))
        MatcherAssert.assertThat(superEggDropRecur(case.first, case.second), CoreMatchers.`is`(case.third))
    }
}
