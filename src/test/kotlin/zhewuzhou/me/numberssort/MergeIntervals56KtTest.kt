package zhewuzhou.me.numberssort

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

class MergeIntervals56KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(
                    arrayOf(
                        intArrayOf(1, 3),
                        intArrayOf(2, 6),
                        intArrayOf(8, 10),
                        intArrayOf(15, 18)
                    ),
                    listOf(
                        listOf(1, 6),
                        listOf(8, 10),
                        listOf(15, 18)
                    )
                ),
                Pair(
                    arrayOf(
                        intArrayOf(1, 4),
                        intArrayOf(4, 5)
                    ),
                    listOf(
                        listOf(1, 5)
                    )
                ),
                Pair(
                    arrayOf(
                        intArrayOf(1, 4),
                        intArrayOf(0, 4)
                    ),
                    listOf(
                        listOf(0, 4)
                    )
                ),
                Pair(
                    arrayOf(
                        intArrayOf(1, 4),
                        intArrayOf(2, 3)
                    ),
                    listOf(
                        listOf(1, 4)
                    )
                ),
                Pair(
                    arrayOf(
                        intArrayOf(2, 3),
                        intArrayOf(4, 5),
                        intArrayOf(6, 7),
                        intArrayOf(8, 9),
                        intArrayOf(1, 10)
                    ),
                    listOf(
                        listOf(1, 10)
                    )
                ),
                Pair(
                    arrayOf(
                        intArrayOf(0, 0),
                        intArrayOf(1, 2),
                        intArrayOf(5, 5),
                        intArrayOf(2, 4),
                        intArrayOf(3, 3),
                        intArrayOf(5, 6),
                        intArrayOf(5, 6),
                        intArrayOf(4, 6),
                        intArrayOf(0, 0),
                        intArrayOf(1, 2),
                        intArrayOf(0, 2),
                        intArrayOf(4, 5)
                    ),
                    listOf(
                        listOf(0, 6)
                    )
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should merge intervals`(case: Pair<Array<IntArray>, List<List<Int>>>) {
        assertThat(merge(case.first).toList().map { it.toList() },
            containsInAnyOrder(*case.second.toTypedArray()))
    }
}
