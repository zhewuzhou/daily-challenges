package zhewuzhou.me.tree

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.utils.TreeNode
import zhewuzhou.utils.toTreeNode
import java.util.*

internal class BalancedBinaryTree110KtTest {
    companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(listOf(3, 9, 20, TreeNode.NullNode, TreeNode.NullNode, 15, 7).toTreeNode(), true),
                Pair(listOf(1, 2, 2, 3, 3, TreeNode.NullNode, TreeNode.NullNode, 4, 4).toTreeNode(), false),
                Pair(listOf<Int>().toTreeNode(), true)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should create tree based on inorder and preorder arrays`(case: Pair<TreeNode?, Boolean>) {
        assertThat(isBalanced(case.first), `is`(case.second))
    }
}
