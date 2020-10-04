package zhewuzhou.me.numberssort

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class GrayCode89KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(0, listOf(0)),
                Pair(1, listOf(0, 1)),
                Pair(2, listOf(0, 1, 3, 2)),
                Pair(3, listOf(0, 1, 3, 2, 6, 7, 5, 4)),
                Pair(4, listOf(0, 1, 3, 2, 6, 7, 5, 4, 12, 13, 15, 14, 10, 11, 9, 8))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should sort the gray code of array`(case: Pair<Int, List<Int>>) {
        assertThat(grayCode(case.first), `is`(case.second))
    }


    @Test
    fun `Should tell diff only 1 bit`() {
        assertThat(isDiffInOneBit(6, 7), `is`(true))
        assertThat(isDiffInOneBit(6, 3), `is`(false))
    }
}
