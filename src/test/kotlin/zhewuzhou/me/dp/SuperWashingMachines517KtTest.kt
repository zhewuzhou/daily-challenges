package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class SuperWashingMachines517KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
                arrayOf(
                        Pair(intArrayOf(1, 0, 5), 3),
                        Pair(intArrayOf(0, 3, 0), 2),
                        Pair(intArrayOf(0, 2, 0), -1)
                )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find the minimal steps to make all machines the same dresses`(case: Pair<IntArray, Int>) {
        assertThat(findMinMoves(case.first), `is`(case.second))
    }
}