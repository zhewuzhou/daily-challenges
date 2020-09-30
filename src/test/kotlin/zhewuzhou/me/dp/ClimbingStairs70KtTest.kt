package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class ClimbingStairs70KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(2, 2),
                Pair(3, 3),
                Pair(4, 5),
                Pair(5, 8),
                Pair(6, 13),
                Pair(7, 21),
                Pair(8, 34),
                Pair(9, 55),
                Pair(10, 89),
                Pair(11, 144),
                Pair(12, 233),
                Pair(13, 377),
                Pair(14, 610),
                Pair(45, 1836311903)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate all possible combs`(case: Pair<Int, Int>) {
        assertThat(climbStairs(case.first), `is`(case.second))
    }
}
