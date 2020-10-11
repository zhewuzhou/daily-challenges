package zhewuzhou.me.tree

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.utils.TreeNode
import zhewuzhou.utils.toTreeNode
import java.util.*

internal class BSTIteratorTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(
                    listOf(70, 30, 115, 20, 40, 90, 200, 10, 25, 35, 45, 80, 95, 150, 210).toTreeNode(),
                    listOf(10, 20, 25, 30, 35, 40, 45, 70, 80, 90, 95, 115, 150, 200, 210)
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should iterator tree in ascending order `(case: Pair<TreeNode?, List<Int>>) {
        val iterator = BSTIterator(case.first)
        for (v in case.second) {
            assertThat(iterator.hasNext(), `is`(true))
            assertThat(iterator.next(), `is`(v))
        }
        assertThat(iterator.hasNext(), `is`(false))
    }

    @Test
    fun `Should iterator tree only have root`() {
        val iterator = BSTIterator(TreeNode(0))
        assertThat(iterator.hasNext(), `is`(true))
        assertThat(iterator.next(), `is`(0))
        assertThat(iterator.hasNext(), `is`(false))
    }
}
