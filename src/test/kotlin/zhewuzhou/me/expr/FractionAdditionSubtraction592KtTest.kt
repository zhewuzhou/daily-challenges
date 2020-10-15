package zhewuzhou.me.expr

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class FractionAdditionSubtraction592KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair("-1/2+1/2", "0/1"),
                Pair("-1/2+1/2+1/3", "1/3"),
                Pair("1/3-1/2", "-1/6"),
                Pair("5/3+1/3", "2/1")
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate fractions correctly`(case: Pair<String, String>) {
        assertThat(fractionAddition(case.first), `is`(case.second))
    }

    @Test
    fun `Should create fraction number`() {
        assertThat(Fraction(1, -2).toString(), `is`("-1/2"))
        assertThat(Fraction(2, -4).toString(), `is`("-1/2"))
        assertThat(Fraction(-4, 2).toString(), `is`("-2/1"))
    }

    @Test
    fun `Should add value`() {
        val lhs = Fraction(1, -2)
        val rhs = Fraction(1, 3)
        assertThat(lhs.plus(rhs).toString(), `is`("-1/6"))
    }
}
