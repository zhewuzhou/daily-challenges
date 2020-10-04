package zhewuzhou.me.backtracing

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class InterleavingString97KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(Triple("aabcc", "dbbca", "aadbbcbcac"), true),
                Pair(Triple("aabcc", "dbbca", "aadbbbaccc"), false),
                Pair(Triple("", "", ""), true)
            )
        )
    }


    @ParameterizedTest
    @MethodSource("cases")
    fun `Should determine if target string are formed by interleave`(case: Pair<Triple<String, String, String>, Boolean>) {
        val input = case.first
        assertThat(isInterleave(input.first, input.second, input.third), `is`(case.second))
    }
}
