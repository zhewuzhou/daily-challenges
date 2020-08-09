package zhewuzhou.me.datastructure

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class MedianFinderTest {
    @Test
    fun `Should find the median in constant time`() {
        val mf = MedianFinder()
        mf.addNum(1)
        mf.addNum(100)
        mf.addNum(50)
        assertThat(mf.findMedian(), `is`(50.0))
        mf.addNum(51)
        assertThat(mf.findMedian(), `is`(50.5))
    }

    @Test
    fun `Should find the median in constant time when large mount of duplicated element`() {
        val mf = MedianFinder()
        mf.addNum(1)
        mf.addNum(1)
        mf.addNum(1)
        assertThat(mf.findMedian(), `is`(1.0))
        mf.addNum(100)
        assertThat(mf.findMedian(), `is`(1.0))
    }

    @Test
    fun `Official case`() {
        val mf = MedianFinder()
        mf.addNum(2)
        mf.addNum(3)
        assertThat(mf.findMedian(), `is`(2.5))
        mf.addNum(100)
        assertThat(mf.findMedian(), `is`(3.0))
        mf.addNum(1)
        assertThat(mf.findMedian(), `is`(2.5))
    }
}
