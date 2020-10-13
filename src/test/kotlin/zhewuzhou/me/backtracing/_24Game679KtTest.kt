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
                Pair(intArrayOf(4, 1, 8, 7), true)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should judege if 24 can be made`(case: Pair<Int, Int>) {
        assertThat(case.first, `is`(case.second))
    }
}
