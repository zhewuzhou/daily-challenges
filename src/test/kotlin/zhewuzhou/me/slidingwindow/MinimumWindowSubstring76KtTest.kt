package zhewuzhou.me.slidingwindow

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class MinimumWindowSubstring76KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple("ADOBECODEBANC", "ABC", "BANC"),
                Triple("aa", "aa", "aa"),
                Triple("a", "a", "a"),
                Triple("ABXYZACBD", "ABC", "ACB")
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate min window`(case: Triple<String, String, String>) {
        assertThat(minWindow(case.first, case.second), `is`(case.third))
    }
}
