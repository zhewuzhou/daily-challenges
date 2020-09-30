package zhewuzhou.me.backtracing

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class Subsets78KtTest {

    @Test
    fun `Should return all subsets`() {
        val res = subsets(arrayOf(1, 2, 3, 4, 5).toIntArray())
        assertThat(res.size, `is`(32))
    }

    @Test
    fun `Should return all subsets for edge case`() {
        val res = subsets(arrayOf(1).toIntArray())
        assertThat(res.size, `is`(2))
    }
}
