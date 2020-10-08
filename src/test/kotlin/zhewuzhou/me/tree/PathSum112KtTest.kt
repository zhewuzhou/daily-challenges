package zhewuzhou.me.tree

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.utils.TreeNode
import zhewuzhou.utils.TreeNode.Companion.NullNode
import zhewuzhou.utils.toTreeNode
import java.util.*

internal class PathSum112KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(listOf(5, 4, 8, 11, NullNode, 13, 4, 7, 2, NullNode, NullNode, NullNode, 1).toTreeNode(),
                    22, true),
                Triple(listOf(5, 4, 8, 11, NullNode, 13, 4, 7, 2, NullNode, NullNode, NullNode, 1).toTreeNode(),
                    26, true),
                Triple(listOf(5, 4, 8, 11, NullNode, 13, 4, 7, 2, NullNode, NullNode, NullNode, 1).toTreeNode(),
                    18, true),
                Triple(listOf(5, 4, 8, 11, NullNode, 13, 4, 7, 2, NullNode, NullNode, NullNode, 1).toTreeNode(),
                    27, true),
                Triple(listOf(5, 4, 8, 11, NullNode, 13, 4, 7, 2, NullNode, NullNode, NullNode, 1).toTreeNode(),
                    28, false),
                Triple(listOf(5, 4, 8, 11, NullNode, 13, 4, 7, 2, NullNode, NullNode, NullNode, 1).toTreeNode(),
                    17, false)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find if path exist that equal path sum`(case: Triple<TreeNode?, Int, Boolean>) {
        assertThat(hasPathSum(case.first, case.second), `is`(case.third))
    }
}
