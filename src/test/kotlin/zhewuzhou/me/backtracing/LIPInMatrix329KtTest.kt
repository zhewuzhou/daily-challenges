package zhewuzhou.me.backtracing

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.me.backtracing.dfs.longestIncreasingPath
import java.util.*

internal class LIPInMatrix329KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(arrayOf(
                    intArrayOf(9, 9, 4),
                    intArrayOf(6, 6, 8),
                    intArrayOf(2, 1, 1)
                ), 4),
                Pair(arrayOf(
                    intArrayOf(3, 4, 5),
                    intArrayOf(3, 2, 6),
                    intArrayOf(2, 2, 1)
                ), 4)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate the LIP in matrix`(case: Pair<Array<IntArray>, Int>) {
        assertThat(longestIncreasingPath(case.first), `is`(case.second))
    }
}
