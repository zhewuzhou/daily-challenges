package zhewuzhou.me.expr

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class ParsingBooleanExpr1106KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
                arrayOf(
                        Pair("!(f)", true),
                        Pair("f", false),
                        Pair("|(f,t)", true),
                        Pair("|(f,|(f,|(f,t)))", true),
                        Pair("&(t,f)", false),
                        Pair("|(&(t,f,t),!(t))", false)
                )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should parsing the boolean expr`(case: Pair<String, Boolean>) {
        assertThat(parseBoolExpr(case.first), `is`(case.second))
    }
}