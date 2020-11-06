package zhewuzhou.me.tree

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.utils.toTreeNode
import java.util.*

internal class CountCompleteTreeNodes222KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
                arrayOf(
                        Pair(listOf(1, 2, 3, 4, 5, 6), 6),
                        Pair(listOf(1, 2, 3, 4, 5, 6, 7, 8), 8)
                )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should count tree nodes`(case: Pair<List<Int>, Int>) {
        assertThat(countNodes(case.first.toTreeNode()), `is`(case.second))
    }
}