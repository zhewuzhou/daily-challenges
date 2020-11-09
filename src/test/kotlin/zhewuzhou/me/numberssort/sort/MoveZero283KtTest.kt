package zhewuzhou.me.numberssort.sort

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class MoveZero283KtTest {
    @Test
    fun `Should move zero to the end of the array`() {
        val array = intArrayOf(0, 0, 1, 0, 3, 12)
        val expected = intArrayOf(1, 3, 12, 0, 0, 0)
        moveZeroes(array)
        for (i in expected.indices) {
            assertThat(array[i], `is`(expected[i]))
        }
    }
}
