package zhewuzhou.me.tree

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.me.tree.sumNumbers
import zhewuzhou.utils.TreeNode
import zhewuzhou.utils.toTreeNode
import java.util.*

internal class SumRootLeafNumbers129KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(listOf(4, 9, 0, 5, 1).toTreeNode(), 1026),
                Pair(listOf(1, 2, 3).toTreeNode(), 25)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should return the sum from root`(case: Pair<TreeNode, Int>) {
        assertThat(sumNumbers(case.first), `is`(case.second))
    }
}
