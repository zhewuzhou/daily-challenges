package zhewuzhou.me.linkedlist

import addTwoNumbers2
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.utils.ListNode
import zhewuzhou.utils.toListNode
import java.util.*

internal class AddTwoNumbers2KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(listOf(2, 4, 3).toListNode(), listOf(5, 6, 4).toListNode(), listOf(7, 0, 8).toListNode()),
                Triple(listOf(0).toListNode(), listOf(0, 0, 4).toListNode(), listOf(0, 0, 4).toListNode()),
                Triple(listOf(0, 0, 4).toListNode(), listOf<Int>().toListNode(), listOf(0, 0, 4).toListNode())
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun should_add_two_list(case: Triple<ListNode?, ListNode?, ListNode?>) {
        val result = addTwoNumbers2(case.first, case.second)
        val expect = case.third
        assertThat(ListNode.listEqual(result, expect), `is`(true))
    }
}
