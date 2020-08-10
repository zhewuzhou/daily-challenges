package zhewuzhou.me.datastructure

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class NumArraySumQueryTest {
    @Test
    fun `Should return the sum of array all the time`() {
        val nsp = NumArraySumQuery(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9))
        assertThat(nsp.sumRange(1, 3), `is`(9))
        assertThat(nsp.sumRange(0, 8), `is`(45))
        nsp.update(4, 100)
        assertThat(nsp.sumRange(0, 3), `is`(10))
        assertThat(nsp.sumRange(0, 8), `is`(140))
    }
}
