package zhewuzhou.me.simple

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class MergeSortedArray88KtTest {
    @Test
    fun `Should calculate sequence`() {
        grayCode(3)
    }

    @Test
    fun `Should tell diff only 1 bit`() {
        assertThat(isDiffInOneBit(6, 7), `is`(true))
        assertThat(isDiffInOneBit(6, 3), `is`(false))
    }
}
