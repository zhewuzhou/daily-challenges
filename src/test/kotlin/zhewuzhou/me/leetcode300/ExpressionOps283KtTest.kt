package zhewuzhou.me.leetcode300

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.me.expr.addOperators
import java.util.*

internal class ExpressionOps283KtTest {
    private companion object {
        @JvmStatic
        fun validExps() = Arrays.stream(
            arrayOf(
                Pair("100*0+9", true),
                Pair("0*0", true),
                Pair("10*00+9", false),
                Pair("10*05", false)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("validExps")
    fun `Should know if the exp is valid`(case: Pair<String, Boolean>) {
        assertThat(isValidExp(case.first), `is`(case.second))
    }

    @Test
    fun `Should eval max int`() {
        assertThat(eval("2147483648"), `is`(2147483648L))
    }
}
