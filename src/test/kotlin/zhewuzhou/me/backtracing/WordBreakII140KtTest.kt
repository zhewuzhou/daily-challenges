package zhewuzhou.me.backtracing

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.me.leetcode140.wordBreakII
import java.util.*

internal class WordBreakII140KtTest {
    private companion object {
        @JvmStatic
        fun casesPath() = Arrays.stream(
            arrayOf(
                Triple("leetcode", listOf("leet", "code"), listOf("leet code")),
                Triple("a", listOf(), listOf<String>()),
                Triple("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                    listOf("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"),
                    listOf<String>()),
                Triple("catsanddog", listOf("cat", "cats", "and", "sand", "dog"),
                    listOf("cats and dog", "cat sand dog")),
                Triple("pineapplepenapple", listOf("apple", "pen", "applepen", "pine", "pineapple"),
                    listOf("pine apple pen apple", "pineapple pen apple", "pine applepen apple")),
                Triple("catsandog", listOf("cats", "dog", "sand", "and", "cat"), listOf<String>())
            )
        )
    }

    @ParameterizedTest
    @MethodSource("casesPath")
    fun `Should calculate all possible combinations from dict`(case: Triple<String, List<String>, List<String>>) {
        val result = wordBreakII(case.first, case.second)
        assertThat(result.size, `is`(case.third.size))
    }
}
