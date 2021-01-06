package zhewuzhou.me.daily

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class QueueReconstructionHeight406KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(
                    arrayOf(
                        intArrayOf(7, 0),
                        intArrayOf(4, 4),
                        intArrayOf(7, 1),
                        intArrayOf(5, 0),
                        intArrayOf(6, 1),
                        intArrayOf(5, 2)
                    ), arrayOf(
                        intArrayOf(5, 0),
                        intArrayOf(7, 0),
                        intArrayOf(5, 2),
                        intArrayOf(6, 1),
                        intArrayOf(4, 4),
                        intArrayOf(7, 1)
                    )
                ),
                Pair(
                    arrayOf(
                        intArrayOf(6, 0),
                        intArrayOf(5, 0),
                        intArrayOf(4, 0),
                        intArrayOf(3, 2),
                        intArrayOf(2, 2),
                        intArrayOf(1, 4)
                    ), arrayOf(
                        intArrayOf(4, 0),
                        intArrayOf(5, 0),
                        intArrayOf(2, 2),
                        intArrayOf(3, 2),
                        intArrayOf(1, 4),
                        intArrayOf(6, 0)
                    )
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should rebuild the queue from the array`(case: Pair<Array<IntArray>, Array<IntArray>>) {
        val result = reconstructQueue(case.first)
        assertThat(result.size, `is`(case.second.size))
        for (i in case.second.indices) {
            assertThat(result[i][0], `is`(case.second[i][0]))
            assertThat(result[i][1], `is`(case.second[i][1]))
        }
    }
}