package zhewuzhou.me.expr

import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class ExpressionAddOperators282KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple("123", 6, listOf("1+2+3", "1*2*3")),
                Triple("232", 8, listOf("2*3+2", "2+3*2")),
                Triple("105", 5, listOf("1*0+5", "10-5")),
                Triple("00", 0, listOf("0+0", "0-0", "0*0")),
                Triple("000", 0, listOf(
                    "0+0+0", "0+0-0", "0+0*0",
                    "0*0+0", "0*0-0", "0*0*0",
                    "0-0+0", "0-0-0", "0-0*0")),
                Triple("3456237490", 9191, listOf()),
                Triple("", 0, listOf()),
                Triple("1", 1, listOf("1")),
                Triple("12", 12, listOf("12")),
                Triple("10009", 9, listOf("1*0*0*0+9", "1*0*0+0+9", "1*0*0-0+9", "1*0+0*0+9", "1*0+0+0+9", "1*0+0-0+9",
                    "1*0-0*0+9", "1*0-0+0+9", "1*0-0-0+9", "10*0*0+9", "10*0+0+9", "10*0-0+9",
                    "100*0+9")),
                Triple("2147483648", -2147483648, listOf())
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should return all possible expression`(case: Triple<String, Int, List<String>>) {
        MatcherAssert.assertThat(addOperators(case.first, case.second).sorted(), CoreMatchers.`is`(case.third.sorted()))
    }
}
