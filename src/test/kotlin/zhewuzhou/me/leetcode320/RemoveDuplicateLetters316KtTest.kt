package zhewuzhou.me.leetcode320

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class RemoveDuplicateLetters316KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair("bcabc", "abc"),
                Pair("aa", "a"),
                Pair("", ""),
                Pair("a", "a"),
                Pair("cbacdcbc", "acdb"),
                Pair("abcdabcdabcdabcdabcd", "abcd")
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should remove duplicated letters and leave small sequence`(case: Pair<String, String>) {
        assertThat(removeDuplicateLetters(case.first), `is`(case.second))
    }
}
