package zhewuzhou.me.slidingwindow

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test


internal class ThreeSum15KtTest {

    @Test
    fun `Should works for normal small case`() {
        val nums = listOf(-1, 0, 1, 2, -1, -4).toIntArray()
        assertThat(threeSum(nums), `is`(listOf(listOf(-1, -1, 2), listOf(-1, 0, 1))))
    }

    @Test
    fun `Should works for edge case`() {
        val nums = listOf(0, 0, 0).toIntArray()
        assertThat(threeSum(nums), `is`(listOf(listOf(0, 0, 0))))
    }
}
