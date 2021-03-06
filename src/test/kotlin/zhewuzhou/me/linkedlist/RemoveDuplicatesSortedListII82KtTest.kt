package zhewuzhou.me.linkedlist

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.utils.ListNode
import zhewuzhou.utils.toListNode
import java.util.*

/**
 * TODO: how to create micro bench for performant code?
 */

internal class RemoveDuplicatesSortedListII82KtTest {
    private lateinit var remover: DuplicationsRemover

    @BeforeEach
    fun setUp() {
        remover = DuplicationsRemover()
    }

    private companion object {
        @JvmStatic
        fun partitionCases() = Arrays.stream(
            arrayOf(
                Triple(listOf(1, 4, 3, 2, 5, 2).toListNode(), 3, listOf(1, 2, 2, 4, 3, 5).toListNode()),
                Triple(listOf(1, 4, 3, 2, 5, 2).toListNode(), 6, listOf(1, 4, 3, 2, 5, 2).toListNode()),
                Triple(listOf(1, 4, 3, 2, 5, 2).toListNode(), 0, listOf(1, 4, 3, 2, 5, 2).toListNode())
            )
        )

        @JvmStatic
        fun deleteCases() = Arrays.stream(
            arrayOf(
                Pair(listOf(1, 2, 3, 3, 4, 4, 5).toListNode(), listOf(1, 2, 5).toListNode()),
                Pair(listOf(1, 1, 1, 2, 3).toListNode(), listOf(2, 3).toListNode())
            )
        )

        @JvmStatic
        fun reverseCases() = Arrays.stream(
            arrayOf(
                Pair(Triple(listOf(1, 2, 3, 4, 5).toListNode(), 2, 4),
                    listOf(1, 4, 3, 2, 5).toListNode()),
                Pair(Triple((1..10).toList().toListNode(), 1, 8),
                    listOf(8, 7, 6, 5, 4, 3, 2, 1, 9, 10).toListNode()),
                Pair(Triple((1..10).toList().toListNode(), 1, 10),
                    listOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1).toListNode())
            )
        )
    }

    @ParameterizedTest
    @MethodSource("partitionCases")
    fun `Should partition the linked list with given number`(case: Triple<ListNode?, Int, ListNode?>) {
        val expected = case.third
        val result = remover.partition(case.first, case.second)
        assertThat(ListNode.listEqual(result, expected), `is`(true))
    }

    @ParameterizedTest
    @MethodSource("reverseCases")
    fun `Should reverse the list for given range`(case: Pair<Triple<ListNode?, Int, Int>, ListNode?>) {
        val expected = case.second
        val result = remover.reverseBetween(case.first.first, case.first.second, case.first.third)
        assertThat(ListNode.listEqual(result, expected), `is`(true))
    }

    @ParameterizedTest
    @MethodSource("deleteCases")
    fun `Should delete duplication list nodes`(case: Pair<ListNode?, ListNode?>) {
        val expected = case.second
        val result = remover.deleteDuplicates(case.first)
        assertThat(ListNode.listEqual(result, expected), `is`(true))
    }
}
