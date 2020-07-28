package zhewuzhou.me.leetcode20

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LeetCode11KtTest {

    @Test
    fun `Should calculate area for valid list`() {
        assertThat(maxArea(listOf(1, 8, 6, 2, 5, 4, 8, 3, 7).toIntArray()), `is`(49))
    }

    @Test
    fun `Should calculate area for list 1 1`() {
        assertThat(maxArea(listOf(1, 1).toIntArray()), `is`(1))
    }

    @Test
    fun `Should calculate area for list 1`() {
        Assertions.assertThrows(IllegalStateException::class.java) {
            maxArea(listOf(1).toIntArray())
        }
    }
}
