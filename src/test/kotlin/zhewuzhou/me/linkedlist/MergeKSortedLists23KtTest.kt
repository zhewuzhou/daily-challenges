package zhewuzhou.me.linkedlist

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import zhewuzhou.utils.ListNode
import zhewuzhou.utils.toListNode

internal class MergeKSortedLists23KtTest {

    @Test
    fun `Should merge k list for normal case`() {
        val toMerge = listOf(
            listOf(1, 4, 5).toListNode(),
            listOf(1, 3, 4).toListNode(),
            listOf(2, 6).toListNode()
        ).toTypedArray()

        val result = mergeKLists(toMerge)
        val expect = listOf(1, 1, 2, 3, 4, 4, 5, 6).toListNode()
        assertThat(ListNode.listEqual(result, expect), `is`(true))
    }
}
