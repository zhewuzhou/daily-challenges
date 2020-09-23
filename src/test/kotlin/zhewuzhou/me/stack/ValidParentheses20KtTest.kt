package zhewuzhou.me.stack

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class ValidParentheses20KtTest {

    @Test
    fun `Valid Parentheses ()`() {
        assertThat(isValid("()"), `is`(true))
    }

    @Test
    fun `Valid Parentheses ()(){}`() {
        assertThat(isValid("()[]{}"), `is`(true))
    }

    @Test
    fun `Valid Parentheses {()}`() {
        assertThat(isValid("{()}"), `is`(true))
    }

    @Test
    fun `Valid Parentheses (}`() {
        assertThat(isValid("(}"), `is`(false))
    }

    @Test
    fun `Valid Parentheses ({)}`() {
        assertThat(isValid("({)}"), `is`(false))
    }

    @Test
    fun `Invalid Parentheses (`() {
        assertThat(isValid("("), `is`(false))
    }

    @Test
    fun `Invalid Parentheses empty`() {
        assertThat(isValid(""), `is`(false))
    }
}
