package zhewuzhou.me.tree

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.utils.TreeNode
import zhewuzhou.utils.TreeNode.Companion.NullNode
import zhewuzhou.utils.TreeNode.Companion.treeNodeEqual
import zhewuzhou.utils.toTree
import java.util.*

internal class ConstructBinaryTreePreorderInorder105KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(intArrayOf(3, 9, 20, 15, 7),
                    intArrayOf(9, 3, 15, 20, 7),
                    listOf(3, 9, 20, NullNode, NullNode, 15, 7).toTree())
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should build the tree from pre|in order array`(case: Triple<IntArray, IntArray, TreeNode?>) {
        val result = buildTree(case.first, case.second)
        val expect = case.third
        assertThat(treeNodeEqual(result, expect), `is`(true))
    }
}
