package zhewuzhou.me.tree

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.utils.TreeNode.Companion.treeNodeEqual
import zhewuzhou.utils.toTreeNode
import java.util.*

internal class InvertBinaryTree226KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
                arrayOf(
                        Pair(listOf(4, 2, 7, 1, 3, 6, 9), listOf(4, 7, 2, 9, 6, 3, 1))
                )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should invert tree via plain and recursive approaches`(case: Pair<List<Int>, List<Int>>) {
        val plainResult = invertTree(case.first.toTreeNode())
        val recurResult = invertTreeRecursive(case.first.toTreeNode())
        val expected = case.second.toTreeNode()
        assertThat(treeNodeEqual(plainResult, expected), `is`(true))
        assertThat(treeNodeEqual(recurResult, expected), `is`(true))
    }
}