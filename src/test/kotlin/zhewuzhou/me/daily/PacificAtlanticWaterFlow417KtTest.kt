package zhewuzhou.me.daily

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class PacificAtlanticWaterFlow417KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(
                    arrayOf(
                        intArrayOf(
                            1, 2, 2, 3, 5
                        ),
                        intArrayOf(
                            3, 2, 3, 4, 4
                        ),
                        intArrayOf(
                            2, 4, 5, 3, 1
                        ),
                        intArrayOf(
                            6, 7, 1, 4, 5
                        ),
                        intArrayOf(
                            5, 1, 1, 2, 4
                        )
                    ),
                    listOf(
                        listOf(0, 4),
                        listOf(1, 3),
                        listOf(1, 4),
                        listOf(2, 2),
                        listOf(3, 0),
                        listOf(3, 1),
                        listOf(4, 0)
                    )
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find all of the grids that can flow to both pacific and atlantic`(case: Pair<Array<IntArray>, List<List<Int>>>) {
        val result = pacificAtlantic(case.first)
        assertThat(result.size, `is`(case.second.size))
        for (p in case.second) {
            assertThat(result.contains(p), `is`(true))
        }
    }
}