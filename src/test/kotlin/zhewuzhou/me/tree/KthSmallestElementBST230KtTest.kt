package zhewuzhou.me.tree

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.utils.TreeNode.Companion.NullNode
import zhewuzhou.utils.toTreeNode
import java.util.*

internal class KthSmallestElementBST230KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
                arrayOf(
                        Triple(listOf(3, 1, 4, NullNode, 2), 1, 1),
                        Triple(listOf(5, 3, 6, 2, 4, NullNode, NullNode, 1), 3, 3)

                )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find kth element in tree`(case: Triple<List<Int>, Int, Int>) {
        assertThat(kthSmallest(case.first.toTreeNode(), case.second), `is`(case.third))
    }
}