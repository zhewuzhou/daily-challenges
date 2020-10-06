package zhewuzhou.me.tree

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.utils.TreeNode
import zhewuzhou.utils.TreeNode.Companion.NullNode
import zhewuzhou.utils.toTree
import java.util.*

internal class BinaryTreeLevelOrderTraversal102KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(listOf(3, 9, 20, NullNode, NullNode, 15, 7).toTree(), listOf(
                    listOf(3),
                    listOf(9, 20),
                    listOf(15, 7)
                )),
                Pair(listOf(1, 2, 2, 3, 4, 4, 3).toTree(), listOf(
                    listOf(1),
                    listOf(2, 2),
                    listOf(3, 4, 4, 3)
                ))
            )
        )

        @JvmStatic
        fun zigzagCases() = Arrays.stream(
            arrayOf(
                Pair(listOf(3, 9, 20, NullNode, NullNode, 15, 7).toTree(), listOf(
                    listOf(3),
                    listOf(20, 9),
                    listOf(15, 7)
                )),
                Pair(listOf(1, 2, 2, 3, 4, 4, 3, 5, 6, 7, 8).toTree(), listOf(
                    listOf(1),
                    listOf(2, 2),
                    listOf(3, 4, 4, 3),
                    listOf(8, 7, 6, 5)
                ))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should travel the tree level order`(case: Pair<TreeNode?, List<List<Int>>>) {
        val result = levelOrder(case.first)
        val expect = case.second
        assertThat(result.size, `is`(case.second.size))
        for (l in expect) {
            assertThat(result.contains(l), `is`(true))
        }
    }

    @ParameterizedTest
    @MethodSource("zigzagCases")
    fun `Should travel level in zigzag order`(case: Pair<TreeNode?, List<List<Int>>>) {
        val result = zigzagLevelOrder(case.first)
        val expect = case.second
        assertThat(result.size, `is`(case.second.size))
        for (l in expect) {
            assertThat(result.contains(l), `is`(true))
        }
    }
}
