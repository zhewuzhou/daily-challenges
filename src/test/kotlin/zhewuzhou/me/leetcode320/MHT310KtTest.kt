package zhewuzhou.me.leetcode320

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class MHT310KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(4,
                    arrayOf(
                        intArrayOf(1, 0),
                        intArrayOf(1, 2),
                        intArrayOf(1, 3)),
                    listOf(1)),
                Triple(6,
                    arrayOf(
                        intArrayOf(0, 3),
                        intArrayOf(1, 3),
                        intArrayOf(2, 3),
                        intArrayOf(4, 3),
                        intArrayOf(5, 4)),
                    listOf(3, 4)),
                Triple(1,
                    arrayOf(),
                    listOf(0))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find the MHT for given edges`(case: Triple<Int, Array<IntArray>, List<Int>>) {
        assertThat(findMinHeightTrees(case.first, case.second).sorted(), `is`(case.third.sorted()))
    }
}
