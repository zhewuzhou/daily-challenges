package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class WordLadderKtTest {
    data class WordLadderCase(
        val begin: String,
        val end: String,
        val wordList: List<String>,
        val expected: Int
    )

    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                WordLadderCase("hit",
                    "cog",
                    listOf("hot", "dot", "dog", "lot", "log", "cog"),
                    5),
                WordLadderCase("hit",
                    "cog",
                    listOf("hot", "dot", "dog", "lot", "log"),
                    0),
                WordLadderCase("hit",
                    "cog",
                    listOf(),
                    0),
                WordLadderCase("a",
                    "z",
                    listOf("a", "b", "z"),
                    2),
                WordLadderCase("hit",
                    "logg",
                    listOf("hot", "dot", "dog", "lot", "log"),
                    0),
                WordLadderCase("lost",
                    "miss",
                    listOf("most", "mist", "miss", "lost", "fist", "fish"),
                    4
                ),
                WordLadderCase("leet",
                    "code",
                    listOf("lest", "leet", "lose", "code", "lode", "robe", "lost"),
                    6
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find ladders for word`(case: WordLadderCase) {
        assertThat(ladderLength(case.begin, case.end, case.wordList), `is`(case.expected))
    }

    @Test
    fun `Should see weather 1 word diff`() {
        assertThat(ifOneCharDiff("hit", "hot"), `is`(true))
        assertThat(ifOneCharDiff("log", "cog"), `is`(true))
        assertThat(ifOneCharDiff("hit", "hog"), `is`(false))
        assertThat(ifOneCharDiff("mist", "miss"), `is`(true))
        assertThat(ifOneCharDiff("aaabbbc", "aaabbbd"), `is`(true))
    }
}
