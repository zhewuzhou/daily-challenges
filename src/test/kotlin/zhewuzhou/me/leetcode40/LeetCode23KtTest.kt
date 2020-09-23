package zhewuzhou.me.leetcode40

import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.jupiter.api.Test
import zhewuzhou.me.linkedlist.toListNode

class LeetCode23KtTest {

    @Test
    fun `Should merge k list for normal case`() {
        val toMerge = listOf(
            listOf(1, 4, 5).toListNode(),
            listOf(1, 3, 4).toListNode(),
            listOf(2, 6).toListNode()
        ).toTypedArray()
        var result = mergeKLists(toMerge);

        listOf(1, 1, 2, 3, 4, 4, 5, 6).forEach {
            MatcherAssert.assertThat(result?.`val`, CoreMatchers.`is`(it))
            result = result?.next
        }

    }
}
