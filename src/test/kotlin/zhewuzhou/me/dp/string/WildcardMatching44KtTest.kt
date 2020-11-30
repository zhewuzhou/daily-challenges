package zhewuzhou.me.dp.string

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class WildcardMatching44KtTest {
    private companion object {
        val VERY_LONG_S = "aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba"
        val STRANGE_P = "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*"

        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple("aa", "a", false),
                Triple("aa", "*", true),
                Triple("cb", "?a", false),
                Triple("adceb", "*a*b", true),
                Triple(VERY_LONG_S, STRANGE_P, true),
                Triple("acdcb", "a*c?b", false),
                Triple("abefcdgiescdfimde", "ab*cd?i*de", true)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should match cases`(case: Triple<String, String, Boolean>) {
        assertThat(isMatch44Recur(case.first, case.second), `is`(case.third))
        assertThat(isMatch44DP(case.first, case.second), `is`(case.third))
    }
}
