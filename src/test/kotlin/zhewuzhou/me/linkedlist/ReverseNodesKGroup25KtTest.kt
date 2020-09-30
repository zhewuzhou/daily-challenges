package zhewuzhou.me.linkedlist

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.utils.ListNode
import zhewuzhou.utils.toListNode
import java.util.*

internal class ReverseNodesKGroup25KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(listOf(1, 2, 3, 4, 5).toListNode(), 2, listOf(2, 1, 4, 3, 5).toListNode()),
                Triple(listOf(1, 2, 3, 4, 5).toListNode(), 3, listOf(3, 2, 1, 4, 5).toListNode()),
                Triple(listOf(1, 2).toListNode(), 2, listOf(2, 1).toListNode())
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should reverse k elements`(case: Triple<ListNode?, Int, ListNode?>) {
        var result = reverseKGroup(case.first, case.second)
        var expect = case.third
        while (result != null && expect != null) {
            assertThat(result.`val`, `is`(expect.`val`))
            result = result.next
            expect = expect.next
        }
        assertThat(result == null, `is`(true))
        assertThat(expect == null, `is`(true))
    }
}
