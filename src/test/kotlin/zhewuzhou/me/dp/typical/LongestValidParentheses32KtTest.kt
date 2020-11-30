package zhewuzhou.me.dp.typical

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class LongestValidParentheses32KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
                arrayOf(
                        Pair("(()", 2),
                        Pair(")()())", 4),
                        Pair("()(())", 6),
                        Pair("()(()", 2)
                )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate the LVP`(case: Pair<String, Int>) {
        assertThat(longestValidParentheses(case.first), `is`(case.second))
        assertThat(longestValidParenthesesRecur(case.first), `is`(case.second))
    }
}
