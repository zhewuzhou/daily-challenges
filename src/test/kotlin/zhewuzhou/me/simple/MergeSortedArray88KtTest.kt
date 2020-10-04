package zhewuzhou.me.simple

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class MergeSortedArray88KtTest {
    @Test
    fun `Should merge sorted arrays`() {
        val mergeTo = intArrayOf(1, 2, 3, 0, 0, 0)
        merge(mergeTo, 3, intArrayOf(2, 5, 6), 3)
        assertThat(mergeTo.toList(), `is`(listOf(1, 2, 2, 3, 5, 6)))
    }
}
