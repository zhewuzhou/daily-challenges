package zhewuzhou.me.leetcode240

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.me.linkedlist.isPalindrome
import zhewuzhou.utils.ListNode
import zhewuzhou.utils.toListNode
import java.util.*

internal class LeetCode234KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
                arrayOf(
                        Pair(listOf(1), true),
                        Pair(listOf(1, 2), false),
                        Pair(listOf(1, 2, 1), true),
                        Pair(listOf(1, 2, 2, 1), true),
                        Pair(listOf(1, 2, 5, 2, 1), true),
                        Pair(listOf(1, 2, 5, 3, 1), false),
                        Pair(listOf(1, 2, 5, 5, 3, 1), false),
                        Pair(listOf(1, 2, 5, 5, 2, 1), true)
                )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should determine if list is palindrome`(case: Pair<List<Int>, Boolean>) {
        val expected = case.first.toListNode()
        val head = case.first.toListNode()
        assertThat(isPalindrome(head), `is`(case.second))
        assertThat(ListNode.listEqual(expected, head), `is`(true))
    }
}
