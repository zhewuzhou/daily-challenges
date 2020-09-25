package zhewuzhou.me.numberssort

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class FindFirstLastPosition34KtTest {
    private companion object {
        @JvmStatic
        fun argumentsSearch() =
            Arrays.stream(
                arrayOf(
                    Triple(listOf(5, 7, 7, 8, 8, 10), 8, listOf(3, 4)),
                    Triple(listOf(5, 7, 7, 8, 8, 10), 7, listOf(1, 2)),
                    Triple(listOf(5, 7, 7, 8, 8, 10), 6, listOf(-1, -1)),
                    Triple((1..1000).toList(), 1001, listOf(-1, -1)),
                    Triple((1..10000).toList(), 10001, listOf(-1, -1)),
                    Triple(
                        listOf((1..45000), (45000..50000)).flatMap { it.toList() },
                        45000, listOf(44999, 45000)),
                    Triple(listOf(1), 1, listOf(0, 0)),
                    Triple(listOf(1), 2, listOf(-1, -1))
                )
            )

        @JvmStatic
        fun argumentsInserts() =
            Arrays.stream(
                arrayOf(
                    Triple(listOf(1, 3, 5, 6), 5, 2),
                    Triple(listOf(1, 3, 5, 6), 2, 1),
                    Triple(listOf(1, 3, 5, 6), 7, 4),
                    Triple(listOf(1, 3, 5, 6), 0, 0),
                    Triple(listOf(1), 1, 0),
                    Triple(listOf(1, 3), 1, 0)
                )
            )
    }

    @ParameterizedTest
    @MethodSource("argumentsSearch")
    fun `Should calculate range`(case: Triple<List<Int>, Int, List<Int>>) {
        val nums = case.first.toIntArray()
        val expected = case.third.toIntArray()
        assertThat(searchStart(nums, case.second), `is`(expected[0]))
        assertThat(searchEnd(nums, case.second), `is`(expected[1]))
    }

    @ParameterizedTest
    @MethodSource("argumentsInserts")
    fun `Should find insertion pos`(case: Triple<List<Int>, Int, Int>) {
        val nums = case.first.toIntArray()
        val expected = case.third
        assertThat(searchInsert(nums, case.second), `is`(expected))
    }
}
