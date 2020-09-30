package zhewuzhou.me.linkedlist

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import zhewuzhou.utils.toListNode

internal class MergeKSortedLists23KtTest {

    @Test
    fun `Should merge k list for normal case`() {
        val toMerge = listOf(
            listOf(1, 4, 5).toListNode(),
            listOf(1, 3, 4).toListNode(),
            listOf(2, 6).toListNode()
        ).toTypedArray()
        var result = mergeKLists(toMerge)

        listOf(1, 1, 2, 3, 4, 4, 5, 6).forEach {
            assertThat(result?.`val`, `is`(it))
            result = result?.next
        }

    }
}
