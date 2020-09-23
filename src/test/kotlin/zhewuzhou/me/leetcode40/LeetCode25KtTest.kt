package zhewuzhou.me.leetcode40

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import zhewuzhou.me.linkedlist.toListNode

class LeetCode25KtTest {

    @Test
    fun `Should return 3th element from list 1-2-3-4-5`() {
        val head = listOf(1, 2, 3, 4, 5).toListNode()
        val third = nthEleInList(head, 3)
        val fourth = nthEleInList(head, 4)
        assertThat(third?.`val`, `is`(3))
        assertThat(fourth?.`val`, `is`(4))
    }

    @Test
    fun `Should reverse list 1-2-3-4-5`() {
        val head = listOf(1, 2, 3, 4, 5).toListNode()
        var result = reverse(head, 5).first
        listOf(5, 4, 3, 2, 1).forEach {
            assertThat(result?.`val`, `is`(it))
            result = result?.next
        }
    }

    @Test
    fun `Reverse list 1-2-3-4-5 by 2`() {
        val head = listOf(1, 2, 3, 4, 5).toListNode()
        var result = reverseKGroup(head, 2)
        listOf(2, 1, 4, 3, 5).forEach {
            assertThat(result?.`val`, `is`(it))
            result = result?.next
        }
    }

    @Test
    fun `Reverse list 1-2-3-4-5 by 3`() {
        val head = listOf(1, 2, 3, 4, 5).toListNode()
        var result = reverseKGroup(head, 3)
        listOf(3, 2, 1, 4, 5).forEach {
            assertThat(result?.`val`, `is`(it))
            result = result?.next
        }
    }

    @Test
    fun `Reverse list 1-2 by 2`() {
        val head = listOf(1, 2).toListNode()
        var result = reverseKGroup(head, 2)
        listOf(2, 1).forEach {
            assertThat(result?.`val`, `is`(it))
            result = result?.next
        }
    }
}
