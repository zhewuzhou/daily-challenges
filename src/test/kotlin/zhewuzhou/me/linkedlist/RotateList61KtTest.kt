package zhewuzhou.me.linkedlist

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.utils.ListNode
import zhewuzhou.utils.toListNode
import java.util.*

internal class RotateList61KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple((0..2).toList().toListNode(), 4, listOf(2, 0, 1).toListNode()),
                Triple((1..5).toList().toListNode(), 2, listOf(4, 5, 1, 2, 3).toListNode()),
                Triple((1..5).toList().toListNode(), 5, listOf(1, 2, 3, 4, 5).toListNode()),
                Triple((1..5).toList().toListNode(), 0, listOf(1, 2, 3, 4, 5).toListNode()),
                Triple(listOf(1).toListNode(), 100, listOf(1).toListNode()),
                Triple(listOf<Int>().toListNode(), 100, listOf<Int>().toListNode())
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should rotate the list`(case: Triple<ListNode?, Int, ListNode?>) {
        val result = rotateRight(case.first, case.second)
        assertThat(result?.equals(case.third) ?: true, `is`(true))
    }
}
