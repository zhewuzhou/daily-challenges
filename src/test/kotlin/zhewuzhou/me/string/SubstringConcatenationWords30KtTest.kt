package zhewuzhou.me.string

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class SubstringConcatenationWords30KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple("barfoothefoobarman", arrayOf("foo", "bar"), listOf(0, 9)),
                Triple("foobarfoobar", arrayOf("foo", "bar"), listOf(0, 3, 6)),
                Triple("aaa", arrayOf("a", "a"), listOf(0, 1)),
                Triple("wordgoodgoodgoodbestword", arrayOf("word", "good", "best", "word"), listOf())
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find sub strings for long string`(case: Triple<String, Array<String>, List<Int>>) {
        assertThat(findSubstring(case.first, case.second).sorted(), `is`(case.third.sorted()))
    }
}
