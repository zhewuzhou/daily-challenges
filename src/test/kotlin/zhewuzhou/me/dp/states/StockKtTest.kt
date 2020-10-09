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

        @JvmStatic
        fun cases188() = Arrays.stream(
            arrayOf(
                Triple(intArrayOf(2, 4, 1), 2, 2),
                Triple(intArrayOf(3, 2, 6, 5, 0, 3), 2, 7),
                Triple(intArrayOf(3, 3, 5, 0, 0, 3, 1, 4), 2, 6),
                Triple(intArrayOf(1, 4, 2, 7), 2, 8)
            )
        )

        @JvmStatic
        fun cases309() = Arrays.stream(
            arrayOf(
                Pair(intArrayOf(1, 2, 3, 0, 2), 3),
                Pair(intArrayOf(1, 2, 3, 100, 2), 99),
                Pair(intArrayOf(1, 2, 4, 2, 5, 7, 2, 4, 9, 0), 11),
                Pair(intArrayOf(6, 1, 6, 4, 3, 0, 2), 7)
            )
        )

        @JvmStatic
        fun cases714() = Arrays.stream(
            arrayOf(
                Triple(intArrayOf(1, 3, 2, 8, 4, 9), 2, 8),
                Triple(intArrayOf(1, 3, 2, 8, 4, 9), 1, 10),
                Triple(intArrayOf(1, 3, 2, 8, 4, 9), 7, 1)
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
        assertThat(maxProfit123Rec(case.first), `is`(case.second))
    }

    @ParameterizedTest
    @MethodSource("cases188")
    fun `Should calculate max profit for 188`(case: Triple<IntArray, Int, Int>) {
        assertThat(maxProfit188(case.second, case.first), `is`(case.third))
        assertThat(maxProfit188DP(case.second, case.first), `is`(case.third))
    }

    @ParameterizedTest
    @MethodSource("cases309")
    fun `Should calculate max profit for 309`(case: Pair<IntArray, Int>) {
        assertThat(maxProfit309(case.first), `is`(case.second))
    }

    @ParameterizedTest
    @MethodSource("cases714")
    fun `Should calculate max profit for 714`(case: Triple<IntArray, Int, Int>) {
        assertThat(maxProfit714(case.first, case.second), `is`(case.third))
        assertThat(maxProfit714Status(case.first, case.second), `is`(case.third))
    }
}
