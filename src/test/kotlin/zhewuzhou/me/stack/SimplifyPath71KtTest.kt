package zhewuzhou.me.stack

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class SimplifyPath71KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair("/home/", "/home"),
                Pair("/../", "/"),
                Pair("/home//foo/", "/home/foo"),
                Pair("/a/./b/../../c/", "/c"),
                Pair("/a/../../b/../c//.//", "/c"),
                Pair("/a//b////c/d//././/..", "/a/b/c")
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should simplify the paths`(case: Pair<String, String>) {
        assertThat(simplifyPath(case.first), `is`(case.second))
    }
}
