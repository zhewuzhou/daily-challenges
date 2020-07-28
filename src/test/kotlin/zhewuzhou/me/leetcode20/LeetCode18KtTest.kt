package zhewuzhou.me.leetcode20

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

class LeetCode18KtTest {

    @Test
    fun `Should calculate base case`() {
        val nums = listOf(1, 0, -1, 0, -2, 2).toIntArray()
        val result = fourSum(nums, 0)
        assertThat(result.size, `is`(3))
    }

    @Test
    fun `Should works for even edge cases`(){
        val nums = listOf(0,4,-5,2,-2,4,2,-1,4).toIntArray()
        val result = fourSum(nums, 12)
        assertThat(result.size, `is`(2))

    }
}
