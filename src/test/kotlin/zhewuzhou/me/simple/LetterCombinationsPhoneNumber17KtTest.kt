package zhewuzhou.me.simple

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.junit.jupiter.api.Test

internal class LetterCombinationsPhoneNumber17KtTest {
    @Test
    fun `Should convert digits to possible combinations`() {
        assertThat(letterCombinations("23"),
            containsInAnyOrder("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"))
    }

    @Test
    fun `Should convert digits to possible combinations with 01`() {
        assertThat(letterCombinations("0123"),
            containsInAnyOrder("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"))
    }
}
