package zhewuzhou.me.string

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class LongestCommonPrefix14KtTest {
    @Test
    fun `Should calculate the possible prefix for all simple strings`() {
        val stringArrays = listOf("flower", "flow", "flight").toTypedArray()
        assertThat(longestCommonPrefix(stringArrays), `is`("fl"))
    }

    @Test
    fun `Should calculate the possible prefix for all edge cases`() {
        val stringArrays = listOf("dog", "racecar", "car").toTypedArray()
        assertThat(longestCommonPrefix(stringArrays), `is`(""))
    }
}
