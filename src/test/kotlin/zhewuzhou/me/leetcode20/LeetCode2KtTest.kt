package zhewuzhou.me.leetcode20

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test

class LeetCode2KtTest {

    @Test
    fun should_add_two_list() {
        val result = addTwoNumbers(listOf(2, 4, 3), listOf(5, 6, 4))
        assertThat(result, `is`(listOf(7, 0, 8)))
    }
}
