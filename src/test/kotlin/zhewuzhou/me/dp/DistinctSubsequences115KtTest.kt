package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class DistinctSubsequences115KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple("rabbbit", "rabbit", 3),
                Triple("babgbag", "bag", 5),
                Triple("aaaaaaaaaa", "aa", 45)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate distinct sub sequence`(case: Triple<String, String, Int>) {
        assertThat(numDistinctRecursive(case.first, case.second), `is`(case.third))
    }
}
