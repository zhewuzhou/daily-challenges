package zhewuzhou.me.numberssort

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
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
                        .toIntArray(), -5001),
                Pair((1..1000).toList().toIntArray(), 1001)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should search for the target value in rotated array`(case: Pair<IntArray, Int>) {
        val nums = case.first
        nums.associateBy { nums.indexOf(it) }
            .toMap()
            .forEach { (k, v) -> assertThat(searchVersion2(nums, v), `is`(k)) }
        assertThat(searchVersion2(nums, case.second), `is`(-1))
    }

    @Test
    fun `Should find correct target in 0,1,2,3,4,5,6,7,8,9`() {
        val list = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        val nums = list.toIntArray()
        list.forEach {
            assertThat(binarySearch(nums, it), `is`(it))
        }
    }

    @Test
    fun `Should find pivot for the rotated array 4, 5, 6, 7, 0, 1, 2`() {
        val nums = listOf(4, 5, 6, 7, 0, 1, 2).toIntArray()
        assertThat(findPivot(nums), `is`(4))
    }

    @Test
    fun `Should find pivot for the rotated array 1,2,0`() {
        val nums = listOf(1, 2, 0).toIntArray()
        assertThat(findPivot(nums), `is`(2))
    }

    @Test
    fun `Should find pivot for the rotated array 5,1,3`() {
        val nums = listOf(5, 1, 3).toIntArray()
        assertThat(findPivot(nums), `is`(1))
    }

    @Test
    fun `Should find 0 for the rotated array 1,0`() {
        val nums = listOf(0, 1).toIntArray()
        assertThat(binarySearch(nums, 0), `is`(0))
        assertThat(binarySearch(nums, 1), `is`(1))
        assertThat(binarySearch(nums, 2), `is`(-1))
    }

    @Test
    fun `Should find 0 for the rotated array 0`() {
        val nums = listOf(0).toIntArray()
        assertThat(binarySearch(nums, 0), `is`(0))
        assertThat(binarySearch(nums, 1), `is`(-1))
    }

    @Test
    fun `Should find pivot for the rotated array 0,1,2,3,4,5,6,7`() {
        val nums = listOf(0, 1, 2, 3, 4, 5, 6, 7).toIntArray()
        assertThat(findPivot(nums), `is`(0))
    }

    @Test
    fun `Should find pivot for the rotated array 1,2,3,4,5,6,7,8,9,0`() {
        val nums = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0).toIntArray()
        assertThat(findPivot(nums), `is`(9))
    }

    @Test
    fun `Should find pivot for the rotated array 2,3,4,5,6,7,8,9,0,1`() {
        val nums = listOf(2, 3, 4, 5, 6, 7, 8, 9, 0, 1).toIntArray()
        assertThat(findPivot(nums), `is`(8))
    }
}
