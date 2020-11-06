package zhewuzhou.me.datastructure

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import zhewuzhou.me.datastructure.MyStack

internal class MyStackTest {
    @Test
    fun `Should remove and top the element`() {
        val s = MyStack()
        s.push(1)
        s.push(2)
        assertThat(s.top(), `is`(2))
    }
}
