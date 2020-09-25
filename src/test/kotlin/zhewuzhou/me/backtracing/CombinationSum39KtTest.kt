package zhewuzhou.me.backtracing

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class CombinationSum39KtTest {
    private companion object {
        @JvmStatic
        fun simpleCases() =
            Arrays.stream(
                arrayOf(
                    Triple(intArrayOf(2, 3, 6, 7), 7, listOf(listOf(7), listOf(2, 2, 3))),
                    Triple(intArrayOf(2, 6, 7), 13, listOf(listOf(6, 7), listOf(2, 2, 2, 7))),
                    Triple(intArrayOf(2, 6, 7), 2, listOf(listOf(2))),
                    Triple(intArrayOf(2, 3, 5), 8, listOf(listOf(2, 2, 2, 2), listOf(2, 3, 3), listOf(3, 5))),
                    Triple((1..15).toList().toIntArray(), 5,
                        listOf(
                            listOf(1, 1, 1, 1, 1),
                            listOf(1, 1, 1, 2),
                            listOf(1, 1, 3),
                            listOf(1, 2, 2),
                            listOf(1, 4),
                            listOf(2, 3),
                            listOf(5)
                        )
                    )
                )
            )
    }

    @ParameterizedTest
    @MethodSource("simpleCases")
    fun `Should find all combinations`(case: Triple<IntArray, Int, List<List<Int>>>) {
        val expected = case.third
        val result = combinationSum(case.first, case.second)
        for (l in result) {
            assertThat(expected.filter { it == l.sorted() }.size, `is`(1))
        }
        assertThat(result.size, `is`(expected.size))
    }
}
