package zhewuzhou.me.tree

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.utils.TreeNode
import zhewuzhou.utils.TreeNode.Companion.NullNode
import zhewuzhou.utils.toTree
import java.util.*

internal class SymmetricTree101KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(listOf(1, 2, 2, 3, 4, 4, 3).toTree(), true),
                Pair(listOf(1, 2, 2, 3, 4, 4, 3, 5, 6, 7, 8, 8, 7, 6, 5).toTree(), true),
                Pair(listOf(1, 2, 2, 3, 4, 4, 3, 5, 6, 7, 8, 8, 7, 5, 6).toTree(), false),
                Pair(listOf(1, 2, 2, NullNode, 3, NullNode, 3).toTree(), false)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should know if it's symmetric tree`(case: Pair<TreeNode?, Boolean>) {
        assertThat(isSymmetric(case.first), `is`(case.second))
    }
}
