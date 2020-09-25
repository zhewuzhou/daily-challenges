package zhewuzhou.me.backtracing

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class CombinationSumII40KtTest {
    private companion object {
        @JvmStatic
        fun cases() =
            Arrays.stream(
                arrayOf(
                    Triple(intArrayOf(10, 1, 2, 7, 6, 1, 5),
                        8,
                        listOf(listOf(1, 7), listOf(1, 2, 5), listOf(2, 6), listOf(1, 1, 6))),
                    Triple(intArrayOf(2, 3, 6, 7), 7, listOf(listOf(7))),
                    Triple(intArrayOf(2, 6, 7), 13, listOf(listOf(6, 7))),
                    Triple(intArrayOf(2, 6, 7), 2, listOf(listOf(2))),
                    Triple(intArrayOf(2, 3, 5), 8, listOf(listOf(3, 5))),
                    Triple((1..15).toList().toIntArray(), 8,
                        listOf(
                            listOf(1, 2, 5),
                            listOf(1, 3, 4),
                            listOf(1, 7),
                            listOf(2, 6),
                            listOf(3, 5),
                            listOf(8)
                        )
                    )
                )
            )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find all combinations`(case: Triple<IntArray, Int, List<List<Int>>>) {
        val expected = case.third
        val result = combinationSum2(case.first, case.second)
        for (l in result) {
            assertThat(expected.filter { it == l.sorted() }.size, `is`(1))
        }
        assertThat(result.size, `is`(expected.size))
    }
}
