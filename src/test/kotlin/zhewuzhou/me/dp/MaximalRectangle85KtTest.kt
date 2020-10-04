package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class MaximalRectangle85KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
//                Pair(arrayOf(
//                    charArrayOf('1', '0', '1', '0', '0'),
//                    charArrayOf('1', '0', '1', '1', '1'),
//                    charArrayOf('1', '1', '1', '1', '1'),
//                    charArrayOf('1', '0', '0', '1', '0')
//                ), 6),
//                Pair(arrayOf(charArrayOf()), 0),
//                Pair(arrayOf(charArrayOf('0')), 0),
//                Pair(arrayOf(charArrayOf('1')), 1),
//                Pair(arrayOf(charArrayOf('0', '0')), 0),
//                Pair(arrayOf(charArrayOf('1', '1', '1')), 3),
                Pair(arrayOf(
                    charArrayOf('0', '0', '1', '1', '0'),
                    charArrayOf('1', '1', '1', '1', '1')
                ), 5)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate the maximum area of rectangle`(case: Pair<Array<CharArray>, Int>) {
        assertThat(maximalRectangle(case.first), `is`(case.second))
    }
}
