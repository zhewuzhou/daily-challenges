package zhewuzhou.me.leetcode40

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

class LeetCode32KtTest {

    @Test
    fun `Should return 2 from (()`() {
        assertThat(longestValidParentheses("(()"), `is`(2))
    }

    @Test
    fun `Should return 4 from )()())`() {
        assertThat(longestValidParentheses(")()())"), `is`(4))
    }

    @Test
    fun `Should return 6 from ()(())`() {
        assertThat(longestValidParentheses("()(())"), `is`(6))
    }

    @Test
    fun `Should return 2 from ()(()`() {
        assertThat(longestValidParentheses("()(()"), `is`(2))
    }
}
