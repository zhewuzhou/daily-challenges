package zhewuzhou.me.numberssort

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class RemoveElement27KtTest {
    @Test
    fun `Should remove 3 from 3-2-2-3`() {
        val nums = listOf(3, 2, 2, 3).toIntArray()
        assertThat(removeElement(nums, 3), `is`(2))
    }
}
