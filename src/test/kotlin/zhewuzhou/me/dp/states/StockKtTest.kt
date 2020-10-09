package zhewuzhou.me.dp.states

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class StockKtTest {
    private companion object {
        @JvmStatic
        fun cases1T() = Arrays.stream(
            arrayOf(
                Pair(intArrayOf(7, 1, 5, 3, 6, 4), 5),
                Pair(intArrayOf(7, 6, 4, 3, 1), 0)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases1T")
    fun `Should `(case: Pair<IntArray, Int>) {
        assertThat(maxProfit121(case.first), `is`(case.second))
    }
}
