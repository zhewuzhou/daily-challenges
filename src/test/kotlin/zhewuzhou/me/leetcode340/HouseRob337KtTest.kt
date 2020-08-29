package zhewuzhou.me.leetcode340

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import zhewuzhou.me.leetcode100.TreeNode

internal class HouseRob337KtTest {

    @Test
    fun `Should rob maximum num of money for normal tree`() {
        val root = normalTree()
        assertThat(rob(root), `is`(7))
    }

    @Test
    fun `Should rob maximum num of money large middle tree`() {
        val root = largeMiddleTree()
        assertThat(rob(root), `is`(9))
    }

    private fun normalTree(): TreeNode? {
        val root = TreeNode(3)
        val right = TreeNode(3)
        val left = TreeNode(2)
        root.left = left
        root.right = right
        left.right = TreeNode(3)
        right.right = TreeNode(1)
        return root
    }

    private fun largeMiddleTree(): TreeNode? {
        val root = TreeNode(3)
        val right = TreeNode(4)
        val left = TreeNode(5)
        root.left = left
        root.right = right
        left.left = TreeNode(1)
        left.right = TreeNode(3)
        right.right = TreeNode(1)
        return root
    }
}
