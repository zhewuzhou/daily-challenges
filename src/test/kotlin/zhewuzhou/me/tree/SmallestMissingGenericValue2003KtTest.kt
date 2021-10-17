package zhewuzhou.me.tree

import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.utils.TreeNode
import zhewuzhou.utils.toTreeNode
import java.util.*
import java.util.stream.Stream

internal class SmallestMissingGenericValue2003KtTest {
    private companion object {
        @JvmStatic
        fun cases(): Stream<Triple<IntArray, IntArray, List<Int>>> {
            return Arrays.stream(
                arrayOf(
//                    Triple(intArrayOf(-1, 0, 0, 2), intArrayOf(1, 2, 3, 4), listOf(5, 1, 1, 1)),
//                    Triple(
//                        intArrayOf(-1, 2, 3, 0, 2, 4, 1),
//                        intArrayOf(2, 3, 4, 5, 6, 7, 8),
//                        listOf(1, 1, 1, 1, 1, 1, 1)
//                    ),
//                    Triple(intArrayOf(-1, 0, 1, 0, 3, 3), intArrayOf(5, 4, 6, 2, 1, 3), listOf(7, 1, 1, 4, 2, 1)),
//                    Triple(intArrayOf(-1, 0, 0, 2), intArrayOf(5, 3, 2, 1), listOf(4, 1, 3, 2)),
                    Triple(intArrayOf(-1, 2, 3, 0, 0), intArrayOf(1, 2, 3, 4, 5), listOf(6, 1, 1, 1, 1))
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find the smallest value of generic in subtree`(case: Triple<IntArray, IntArray, List<Int>>) {
        assertThat(smallestMissingValueSubtree(case.first, case.second).toList(), `is`(case.third))
    }
}