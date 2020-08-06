package zhewuzhou.me.leetcode300

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class ExpressionOps283KtTest {
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
    @MethodSource("cases")
    fun `Should return all possible expression`(case: Triple<String, Int, List<String>>) {
        assertThat(addOperatorsSlow(case.first, case.second).sorted(), `is`(case.third.sorted()))
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
