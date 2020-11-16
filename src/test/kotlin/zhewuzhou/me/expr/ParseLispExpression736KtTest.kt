package zhewuzhou.me.expr

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class ParseLispExpression736KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
                arrayOf(
                        Pair("(add 1 2)", 3),
                        Pair("(mult 3 (add 2 3))", 15),
                        Pair("(let x 2 (mult x 5))", 10),
                        Pair("(let x 2 (mult x (let x 3 y 4 (add x y))))", 14),
                        Pair("(let x 1 y 2 x (add x y) (add x y))", 5),
                        Pair("(let a1 3 b2 (add a1 1) b2)", 4)
                )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should eval the lisp src to int`(case: Pair<String, Int>) {
        assertThat(evaluate(case.first), `is`(case.second))
    }
}