package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class FrogJump403KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(intArrayOf(0, 1, 3, 5, 6, 8, 12, 17), true),
                Pair(intArrayOf(0, 1, 2, 3, 4, 8, 9, 11), false)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should see weather the frog could jump cross the river`(case: Pair<IntArray, Boolean>) {
        assertThat(canCross(case.first), `is`(case.second))
    }
}
