package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

/*
Constrains:
s.length is 0..100
t.length is 0..10000
lower case only
trie is not for this because
 */

internal class Subsequence392KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple("abc", "ahbgdc", true),
                Triple("", "", true),
                Triple("aa", "", false),
                Triple("axc", "ahbgdc", false)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should see if string is subsequence of other string`(case: Triple<String, String, Boolean>) {
        assertThat(isSubsequence(case.first, case.second), `is`(case.third))
    }
}
