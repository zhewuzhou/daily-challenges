package zhewuzhou.me.datastructure

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class SurroundedRegions130KtTest {
    @Test
    fun `Surrounded regions should be changed accordingly`() {
        val input = listOf("XXXX", "XOOX", "XXOX", "XOXX").map { it.toCharArray() }.toTypedArray()
        val result = listOf("XXXX", "XXXX", "XXXX", "XOXX").map { it.toCharArray().toList() }
        solve(input)
        assertThat(input.size, `is`(result.size))
        for (i in input.indices) {
            assertThat(input[i].toList(), `is`(result[i]))
        }
    }
}
