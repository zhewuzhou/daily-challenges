package zhewuzhou.me.tree

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import zhewuzhou.utils.TreeNode.Companion.NullNode
import zhewuzhou.utils.toTreeNode

internal class BinaryTreeRightSideView199KtTest {
    @Test
    fun `Should calculate the right view of tree`() {
        val root = listOf(1, 2, 3, NullNode, 5, NullNode, 4).toTreeNode()
        assertThat(rightSideView(root), `is`(listOf(1, 3, 4)))
    }
}
