package zhewuzhou.me.dp.states

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class StockKtTest {
    private companion object {
        @JvmStatic
        fun cases121() = Arrays.stream(
            arrayOf(
                Pair(intArrayOf(7, 1, 5, 3, 6, 4), 5),
                Pair(intArrayOf(7, 6, 4, 3, 1), 0)
            )
        )

        @JvmStatic
        fun cases122() = Arrays.stream(
            arrayOf(
                Pair(intArrayOf(7, 1, 5, 3, 6, 4), 7),
                Pair(intArrayOf(1, 2, 3, 4, 5), 4),
                Pair(intArrayOf(7, 6, 4, 3, 1), 0),
                Pair(intArrayOf(1, 2), 1),
                Pair(intArrayOf(2, 1, 2, 0, 1), 2)
            )
        )


        @JvmStatic
        fun cases123() = Arrays.stream(
            arrayOf(
                Pair(intArrayOf(3, 3, 5, 0, 0, 3, 1, 4), 6),
                Pair(intArrayOf(1, 2, 3, 4, 5), 4),
                Pair(intArrayOf(7, 6, 4, 3, 1), 0),
                Pair(intArrayOf(1, 2), 1),
                Pair(intArrayOf(2, 1, 2, 0, 1), 2),
                Pair(intArrayOf(3, 2, 6, 5, 0, 3), 7),
                Pair(intArrayOf(2, 4, 1), 2),
                Pair(intArrayOf(1, 4, 2, 7), 8),
                Pair(intArrayOf(1, 4), 3),
                Pair(intArrayOf(2, 7), 5)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases121")
    fun `Should calculate max profit for 121`(case: Pair<IntArray, Int>) {
        assertThat(maxProfit121(case.first), `is`(case.second))
    }

    @ParameterizedTest
    @MethodSource("cases122")
    fun `Should calculate max profit for 122`(case: Pair<IntArray, Int>) {
        assertThat(maxProfit122(case.first), `is`(case.second))
    }

    @ParameterizedTest
    @MethodSource("cases123")
    fun `Should calculate max profit for 123`(case: Pair<IntArray, Int>) {
        assertThat(maxProfit123(case.first), `is`(case.second))
    }
}
