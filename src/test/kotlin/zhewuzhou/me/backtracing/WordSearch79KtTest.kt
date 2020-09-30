package zhewuzhou.me.backtracing

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class WordSearch79KtTest {

    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(listOf("ABCE", "SFCS", "ADEE"), "ABCCED", true),
                Triple(listOf("ABCE", "SFCS", "ADEE"), "SEE", true),
                Triple(listOf("ABCE", "SFCS", "ADEE"), "ABCB", false)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find word in matrix`(case: Triple<List<String>, String, Boolean>) {
        val board = case.first.map { it.toCharArray() }.toTypedArray()
        assertThat(exist(board, case.second), `is`(case.third))
    }
}
