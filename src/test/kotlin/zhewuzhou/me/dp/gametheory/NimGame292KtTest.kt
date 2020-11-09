package zhewuzhou.me.dp.gametheory

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.me.dp.gametheory.canWinNim
import java.util.*

internal class NimGame292KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(-1, true),
                Pair(0, true),
                Pair(1, true),
                Pair(2, true),
                Pair(3, true),
                Pair(4, false),
                Pair(5, true),
                Pair(6, true),
                Pair(7, true),
                Pair(8, false),
                Pair(9, true),
                Pair(10, true),
                Pair(11, true),
                Pair(12, false),
                Pair(13, true),
                Pair(14, true),
                Pair(15, true),
                Pair(16, false),
                Pair(Int.MAX_VALUE, true)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should say if can win the game`(case: Pair<Int, Boolean>) {
        assertThat(canWinNim(case.first), `is`(case.second))
    }
}
