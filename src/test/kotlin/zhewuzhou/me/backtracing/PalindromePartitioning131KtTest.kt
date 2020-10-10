package zhewuzhou.me.backtracing

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class PalindromePartitioning131KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair("aab", listOf(listOf("a", "a", "b"), listOf("aa", "b"))),
                Pair("aaaa", listOf(
                    listOf("a", "a", "a", "a"),
                    listOf("a", "aa", "a"),
                    listOf("a", "a", "aa"),
                    listOf("a", "aaa"),
                    listOf("aa", "a", "a"),
                    listOf("aa", "aa"),
                    listOf("aaa", "a"),
                    listOf("aaaa")
                ))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should partition the string with palindrome`(case: Pair<String, List<List<String>>>) {
        val result = partition(case.first)
        val expect = case.second
        assertThat(result.size, `is`(expect.size))
        for (p in expect) {
            assertThat(result.contains(p), `is`(true))
        }
    }
}
