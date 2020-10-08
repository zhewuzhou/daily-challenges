package zhewuzhou.me.tree

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.utils.TreeNode
import zhewuzhou.utils.TreeNode.Companion.NullNode
import zhewuzhou.utils.toTreeNode
import java.util.*

internal class MinDepthBinaryTree111KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(listOf(3, 9, 20, NullNode, NullNode, 15, 7).toTreeNode(), 2)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should `(case: Pair<TreeNode?, Int>) {
        assertThat(minDepth(case.first), `is`(case.second))
    }
}
