package zhewuzhou.me.backtracing

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.me.backtracing.permute
import java.util.*

internal class Permutations46KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(intArrayOf(1, 2, 3), 6),
                Pair(intArrayOf(1, 2, 3, 4), 24),
                Pair(intArrayOf(1, 2, 3, 4, 5), 120),
                Pair(intArrayOf(1, 2, 3, 4, 5, 6), 720),
                Pair(intArrayOf(1, 2, 3, 4, 5, 6, 7), 5040)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should return all permutations`(case: Pair<IntArray, Int>) {
        assertThat(permute(case.first).size, `is`(case.second))
    }
}
