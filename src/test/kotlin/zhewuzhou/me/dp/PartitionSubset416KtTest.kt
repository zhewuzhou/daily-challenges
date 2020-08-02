package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class PartitionSubset416KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(intArrayOf(1, 5, 11, 5), true),
                Pair(intArrayOf(1, 2, 3, 5), false),
                Pair(intArrayOf(10, 1, 2, 3, 4), true),
                Pair(intArrayOf(5, 5, 1, 2, 3, 4), true),
                Pair(intArrayOf(5, 1, 2, 3, 4, 5), true)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should know if can partition the array`(case: Pair<IntArray, Boolean>) {
        assertThat(canPartition(case.first), `is`(case.second))
    }
}
