package zhewuzhou.me.linkedlist

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.utils.ListNode
import zhewuzhou.utils.toListNode
import java.util.*

internal class MergeTwoSortedLists21KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(listOf(1, 2, 4).toListNode(),
                    listOf(1, 3, 4).toListNode(),
                    listOf(1, 1, 2, 3, 4, 4).toListNode()),
                Triple(listOf(1, 2, 4).toListNode(),
                    listOf<Int>().toListNode(),
                    listOf(1, 2, 4).toListNode()),
                Triple(listOf(1, 2, 4).toListNode(),
                    listOf<Int>().toListNode(),
                    listOf(1, 2, 4).toListNode())
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should merge 2 lists`(case: Triple<ListNode?, ListNode?, ListNode?>) {
        var expect = case.third
        var result = mergeTwoLists(case.first, case.second)
        while (expect != null && result != null) {
            assertThat(result.`val`, `is`(expect.`val`))
            expect = expect.next
            result = result.next
        }
        assertThat(result == null, `is`(true))
        assertThat(result == null, `is`(true))
    }
}
