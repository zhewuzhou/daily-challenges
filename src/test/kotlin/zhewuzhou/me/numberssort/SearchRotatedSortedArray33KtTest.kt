package zhewuzhou.me.numberssort

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class SearchRotatedSortedArray33KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(intArrayOf(5, 1, 3), 2),
                Pair(intArrayOf(1, 2, 3, 4, 5), 6),
                Pair(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3),
                Pair(
                    listOf((200..500), (1..100))
                        .flatMap { it.toList() }
                        .toIntArray(), 101),
                Pair(
                    listOf((-100..-1), (-500..-200))
                        .flatMap { it.toList() }
                        .toIntArray(), -101),
                Pair(
                    listOf((2000..5000), (1..1000))
                        .flatMap { it.toList() }
                        .toIntArray(), 1001),
                Pair(
                    listOf((-1000..-1), (-5000..-2000))
                        .flatMap { it.toList() }
                        .toIntArray(), -1001),
                Pair(
                    listOf((5002..9999), (1..5000))
                        .flatMap { it.toList() }
                        .toIntArray(), 5001),
                Pair(
                    listOf((-5000..-1), (-9999..-5002))
                        .flatMap { it.toList() }
                        .toIntArray(), -5001)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should search for the target value in rotated array`(case: Pair<IntArray, Int>) {
        val nums = case.first
        nums.associateBy { nums.indexOf(it) }
            .toMap()
            .forEach { (k, v) -> assertThat(search(nums, v), `is`(k)) }
        assertThat(search(nums, case.second), `is`(-1))
    }
}
