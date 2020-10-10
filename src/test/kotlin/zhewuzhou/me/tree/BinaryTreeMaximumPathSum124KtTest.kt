package zhewuzhou.me.tree

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.utils.TreeNode
import zhewuzhou.utils.TreeNode.Companion.NullNode
import zhewuzhou.utils.toTreeNode
import java.util.*

internal class BinaryTreeMaximumPathSum124KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(listOf(1, 2, 3).toTreeNode(), 6),
                Pair(listOf(-10, 9, 20, NullNode, NullNode, 15, 7).toTreeNode(), 42),
                Pair(listOf(-10, -9, -20, -1, -1, 15, 7).toTreeNode(), 15),
                Pair(listOf(1, 1, 1, 1, 1, 1, 1).toTreeNode(), 5)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate max path sum`(case: Pair<TreeNode?, Int>) {
        assertThat(maxPathSum(case.first), `is`(case.second))
    }
}
