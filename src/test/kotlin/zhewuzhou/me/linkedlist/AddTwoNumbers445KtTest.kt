package zhewuzhou.me.linkedlist

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.utils.ListNode
import zhewuzhou.utils.toListNode
import java.util.*

internal class AddTwoNumbers445KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(listOf(7, 2, 4, 3), listOf(5, 6, 4), listOf(7, 8, 0, 7)),
                Triple(listOf(7, 2, 4, 3), listOf(), listOf(7, 2, 4, 3)),
                Triple(listOf(7, 2, 4, 3), listOf(0), listOf(7, 2, 4, 3)),
                Triple(listOf(9), listOf(9), listOf(1, 8)),
                Triple(listOf(), listOf(5, 6, 4), listOf(5, 6, 4)),
                Triple(listOf(0), listOf(5, 6, 4), listOf(5, 6, 4)),
                Triple(listOf(), listOf(), listOf()),
                Triple(listOf(0), listOf(0), listOf(0)),
                Triple(listOf(9, 9, 9, 9, 9, 9), listOf(9, 9, 9), listOf(1, 0, 0, 0, 9, 9, 8))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should add 2 numbers in linked list`(case: Triple<List<Int>, List<Int>, List<Int>>) {
        val result = addTwoNumbers(case.first.toListNode(), case.second.toListNode())
        val expected = case.third.toListNode()
        assertThat(ListNode.listEqual(result, expected), `is`(true))
    }
}
