package zhewuzhou.me.leetcode300

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
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
                Triple("3456237490", 9191, listOf())
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should return all possible expression`(case: Triple<String, Int, List<String>>) {
        assertThat(addOperators(case.first, case.second).sorted(), `is`(case.third.sorted()))
    }
}
