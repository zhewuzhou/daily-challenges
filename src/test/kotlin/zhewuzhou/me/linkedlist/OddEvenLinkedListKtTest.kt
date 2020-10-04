package zhewuzhou.me.linkedlist

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.utils.ListNode
import zhewuzhou.utils.toListNode
import java.util.*

internal class OddEvenLinkedListKtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(listOf(1, 2, 3, 4, 5), listOf(1, 3, 5, 2, 4)),
                Pair(listOf(1), listOf(1)),
                Pair(listOf(1, 2), listOf(1, 2)),
                Pair(listOf(), listOf()),
                Pair(listOf(2, 1, 3, 5, 6, 4, 7), listOf(2, 3, 6, 7, 1, 5, 4))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should group the odd and even linked list node`(case: Pair<List<Int>, List<Int>>) {
        val expected = case.second.toListNode()
        val result = oddEvenList(case.first.toListNode())
        assertThat(ListNode.listEqual(result, expected), `is`(true))
    }
}
