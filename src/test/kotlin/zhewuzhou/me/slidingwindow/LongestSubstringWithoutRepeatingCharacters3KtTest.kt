package zhewuzhou.me.slidingwindow

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.Arrays.stream

internal class LongestSubstringWithoutRepeatingCharacters3KtTest {
    private companion object {
        @JvmStatic
        fun cases() = stream(
            arrayOf(
                Pair("abcabcbb", 3),
                Pair("bbbbbbbb", 1),
                Pair("pwwkew", 3)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find the longest sequence correctly`(case: Pair<String, Int>) {
        assertThat(lengthOfLongestSubstring(case.first), `is`(case.second))
    }
}
