package zhewuzhou.me.datastructure

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class SummaryRangesTest {
    @Test
    fun `Should show ranges when numbers keep adding`() {
        val sr = SummaryRanges()
        assertThat(toList(sr.getIntervals()), `is`(listOf()))
        sr.addNum(1)
        assertThat(toList(sr.getIntervals()), `is`(listOf(listOf(1, 1))))
        sr.addNum(3)
        assertThat(toList(sr.getIntervals()), `is`(listOf(listOf(1, 1), listOf(3, 3))))
        sr.addNum(7)
        assertThat(toList(sr.getIntervals()), `is`(listOf(listOf(1, 1), listOf(3, 3), listOf(7, 7))))
        sr.addNum(2)
        assertThat(toList(sr.getIntervals()), `is`(listOf(listOf(1, 3), listOf(7, 7))))
        sr.addNum(6)
        assertThat(toList(sr.getIntervals()), `is`(listOf(listOf(1, 3), listOf(6, 7))))
    }

    private fun toList(arr: Array<IntArray>): List<List<Int>> =
        arr.map { it.toList() }.toList()
}
