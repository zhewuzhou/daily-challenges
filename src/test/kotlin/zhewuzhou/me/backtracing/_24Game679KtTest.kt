package zhewuzhou.me.backtracing

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class _24Game679KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(intArrayOf(4, 1, 8, 7), true),
                Pair(intArrayOf(1, 2, 1, 2), false),
                Pair(intArrayOf(3, 8, 3, 8), true)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should judege if 24 can be made`(case: Pair<IntArray, Boolean>) {
        assertThat(judgePoint24(case.first), `is`(case.second))
    }
}
