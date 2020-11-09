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
                        Pair(1, 1)
                )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should parsing the boolean expr`(case: Pair<Int, Int>) {
        assertThat(case.first, `is`(case.second))
    }
}