package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class CanIWin464KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(10, 11, false),
                Triple(10, 40, false)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should see weather player 1 can win`(case: Triple<Int, Int, Boolean>) {
        assertThat(canIWin(case.first, case.second), `is`(case.third))
    }
}
