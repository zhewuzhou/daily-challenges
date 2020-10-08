package zhewuzhou.me.backtracing

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.utils.TreeNode
import zhewuzhou.utils.TreeNode.Companion.NullNode
import zhewuzhou.utils.toTreeNode
import java.util.*

internal class PathSumII113KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(listOf(5, 4, 8, 11, NullNode, 13, 4, 7, 2, NullNode, NullNode, NullNode, NullNode, 5, 1).toTreeNode(),
                    22,
                    listOf(listOf(5, 4, 11, 2), listOf(5, 8, 4, 5)))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find all paths with given sum`(case: Triple<TreeNode?, Int, List<List<Int>>>) {
        val result = pathSum(case.first, case.second)
        assertThat(result.size, `is`(case.third.size))
        assertThat(result, containsInAnyOrder(*case.third.toTypedArray()))
    }
}
