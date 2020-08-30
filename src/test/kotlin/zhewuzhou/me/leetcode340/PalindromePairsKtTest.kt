package zhewuzhou.me.leetcode340

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class PalindromePairsKtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(arrayOf("abcd", "dcba", "lls", "s", "sssll"),
                    listOf(listOf(0, 1), listOf(1, 0), listOf(3, 2), listOf(2, 4))
                ),
                Pair(arrayOf("bat", "tab", "cat"),
                    listOf(listOf(0, 1), listOf(1, 0))
                ),
                Pair(arrayOf("a", ""),
                    listOf(listOf(0, 1), listOf(1, 0))
                ),
                Pair(arrayOf(), listOf())
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find all combinations of indexes that forms palindrome`(case: Pair<Array<String>, List<List<Int>>>) {
        val result = palindromePairs(case.first)
        assertThat(result.size, `is`(case.second.size))
        for (p in result) {
            assertThat(case.second.contains(p), `is`(true))
        }
    }
}
