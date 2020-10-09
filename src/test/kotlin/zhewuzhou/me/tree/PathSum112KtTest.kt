package zhewuzhou.me.tree

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.utils.TreeNode
import zhewuzhou.utils.TreeNode.Companion.NullNode
import zhewuzhou.utils.toTreeNode
import java.util.*
import java.util.stream.Stream

internal class PathSum112KtTest {
    private companion object {
        @JvmStatic
        fun cases(): Stream<Triple<TreeNode?, Int, Boolean>> {
            val tree = listOf(
                5,
                4, 8,
                11, NullNode, 13, 4,
                7, 2, NullNode, NullNode, NullNode, NullNode, NullNode, 1)
                .toTreeNode()
            return Arrays.stream(
                arrayOf(
                    Triple(tree, 22, true),
                    Triple(tree, 26, true),
                    Triple(tree, 18, true),
                    Triple(tree, 27, true),
                    Triple(tree, 28, false),
                    Triple(tree, 17, false)
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find if path exist that equal path sum`(case: Triple<TreeNode?, Int, Boolean>) {
        assertThat(hasPathSum(case.first, case.second), `is`(case.third))
    }
}
