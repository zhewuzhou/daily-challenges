package zhewuzhou.me.numberssort

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class RotateImage48KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(
                    arrayOf(
                        intArrayOf(1, 2, 3),
                        intArrayOf(4, 5, 6),
                        intArrayOf(7, 8, 9)
                    ), listOf(listOf(7, 4, 1), listOf(8, 5, 2), listOf(9, 6, 3))),
                Pair(
                    arrayOf(
                        intArrayOf(1, 2),
                        intArrayOf(3, 4)
                    ), listOf(listOf(3, 1), listOf(4, 2))),
                Pair(
                    arrayOf(
                        intArrayOf(1)
                    ), listOf(listOf(1))),
                Pair(
                    arrayOf(
                        intArrayOf(5, 1, 9, 11),
                        intArrayOf(2, 4, 8, 10),
                        intArrayOf(13, 3, 6, 7),
                        intArrayOf(15, 14, 12, 16)
                    ), listOf(listOf(15, 13, 2, 5), listOf(14, 3, 4, 1), listOf(12, 6, 8, 9), listOf(16, 7, 10, 11)))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should rotate the metrics`(case: Pair<Array<IntArray>, List<List<Int>>>) {
        val metrics = case.first
        rotate(metrics)
        metrics.forEachIndexed { idx, arr ->
            assertThat(arr.toList(), `is`(case.second[idx]))
        }
    }
}
