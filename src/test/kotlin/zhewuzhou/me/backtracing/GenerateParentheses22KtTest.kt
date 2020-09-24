package zhewuzhou.me.backtracing

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.junit.jupiter.api.Test

internal class GenerateParentheses22KtTest {
    @Test
    fun `Should generate all possible parentheses given 3`() {
        assertThat(generateParenthesisBackTracing(3),
            containsInAnyOrder(
                "((()))",
                "(()())",
                "(())()",
                "()(())",
                "()()()"))
    }

    @Test
    fun `Should add one more () in possible position for ((()))`() {
        assertThat(addParenthesis("((()))"),
            containsInAnyOrder(
                "()((()))",
                "(()(()))",
                "((()()))",
                "(((())))",
                "((())())",
                "((()))()"))
    }

    @Test
    fun `Should add one more () in possible position for ()()`() {
        assertThat(addParenthesis("()()"),
            containsInAnyOrder(
                "()()()",
                "(())()",
                "()(())"))
    }
}
