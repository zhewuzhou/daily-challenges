package zhewuzhou.me.d

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.me.dp.calculateMinimumHP
import zhewuzhou.me.dp.calculateMinimumHPRecur
import java.util.*

internal class DungeonGame174KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
                arrayOf(
                        Pair(arrayOf(intArrayOf(-2, -3, 3), intArrayOf(-5, -10, 1), intArrayOf(10, 30, -5)), 7),
                        Pair(arrayOf(intArrayOf(1, -3, 3), intArrayOf(0, -2, 0), intArrayOf(-3, -3, -3)), 3),
                        Pair(arrayOf(intArrayOf(100)), 1),
                        Pair(arrayOf(intArrayOf(100, -100)), 1),
                        Pair(arrayOf(intArrayOf(100, 200, 300)), 1),
                        Pair(arrayOf(intArrayOf(100, -101)), 2),
                        Pair(arrayOf(intArrayOf(-2, -4), intArrayOf(3, -3)), 3)
                )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate minimal health points`(case: Pair<Array<IntArray>, Int>) {
        assertThat(calculateMinimumHP(case.first), `is`(case.second))
        assertThat(calculateMinimumHPRecur(case.first), `is`(case.second))
    }
}
