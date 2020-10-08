package zhewuzhou.me.tree

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.utils.TreeNode
import zhewuzhou.utils.TreeNode.Companion.NullNode
import zhewuzhou.utils.TreeNode.Companion.treeNodeEqual
import zhewuzhou.utils.toTreeNode
import java.util.*

internal class ConstructBinaryTreeInorderPostorder106KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(intArrayOf(9, 3, 15, 20, 7),
                    intArrayOf(9, 15, 7, 20, 3),
                    listOf(3, 9, 20, NullNode, NullNode, 15, 7).toTreeNode())
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should build tree according to inorder and postorder`(case: Triple<IntArray, IntArray, TreeNode?>) {
        val b = ConstructBinaryTreeInorderPostorder106()
        val result = b.buildTree(case.first, case.second)
        val expect = case.third
        assertThat(treeNodeEqual(result, expect), `is`(true))
    }
}
