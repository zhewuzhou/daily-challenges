package zhewuzhou.me.hashing

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.me.hashing.maxProduct
import java.util.*

internal class MaximumProduct318KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(arrayOf("abcw", "baz", "foo", "bar", "xtfn", "abcdef"), 16),
                Pair(arrayOf("abcw", "zba", "ofo", "rba", "xtfn", "defabc"), 16),
                Pair(arrayOf("a", "ab", "abc", "d", "cd", "bcd", "abcd"), 4),
                Pair(arrayOf("a", "aa", "aaa", "aaaa"), 0)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate the product of maximum words`(case: Pair<Array<String>, Int>) {
        assertThat(maxProduct(case.first), `is`(case.second))
    }
}
