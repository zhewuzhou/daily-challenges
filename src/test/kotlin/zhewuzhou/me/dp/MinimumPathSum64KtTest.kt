package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class MinimumPathSum64KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(arrayOf(
                    intArrayOf(1, 3, 1),
                    intArrayOf(1, 5, 1),
                    intArrayOf(4, 2, 1)
                ), 7),
                Pair(arrayOf(
                    intArrayOf(1, 3, 10),
                    intArrayOf(10, 5, 1),
                    intArrayOf(4, 2, 1)
                ), 11)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find the min sum path from top left to bottom right`(case: Pair<Array<IntArray>, Int>) {
        assertThat(minPathSum(case.first), `is`(case.second))
    }
}
