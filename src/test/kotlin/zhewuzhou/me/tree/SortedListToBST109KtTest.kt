package zhewuzhou.me.tree

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.utils.ListNode
import zhewuzhou.utils.TreeNode
import zhewuzhou.utils.TreeNode.Companion.NullNode
import zhewuzhou.utils.TreeNode.Companion.treeNodeEqual
import zhewuzhou.utils.toListNode
import zhewuzhou.utils.toTreeNode
import java.util.*

internal class SortedListToBST109KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(listOf(-10, -3, 0, 5, 9).toListNode(), listOf(0, -3, 9, -10, NullNode, 5).toTreeNode()),
                Pair(listOf(0).toListNode(), listOf(0).toTreeNode()),
                Pair(listOf<Int>().toListNode(), listOf<Int>().toTreeNode()),
                Pair(listOf(1, 3).toListNode(), listOf(3, 1).toTreeNode())
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should convert the sorted list to BST`(case: Pair<ListNode?, TreeNode?>) {
        val result = sortedListToBST(case.first)
        val expect = case.second
        assertThat(treeNodeEqual(result, expect), `is`(true))
    }
}
