package zhewuzhou.me.linkedlist

import addTwoNumbers2
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class AddTwoNumbers2KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(listOf(2, 4, 3).toListNode(), listOf(5, 6, 4).toListNode(), listOf(7, 0, 8).toListNode()),
                Triple(listOf(0).toListNode(), listOf(0, 0, 4).toListNode(), listOf(0, 0, 4).toListNode()),
                Triple(listOf(0, 0, 4).toListNode(), listOf<Int>().toListNode(), listOf(0, 0, 4).toListNode())
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun should_add_two_list(case: Triple<ListNode?, ListNode?, ListNode?>) {
        var result = addTwoNumbers2(case.first, case.second)
        var expect = case.third
        while (result != null && expect != null) {
            assertThat(result.`val`, Matchers.`is`(expect.`val`))
            result = result.next
            expect = expect.next
        }
        assertThat(expect == null, Matchers.`is`(true))
        assertThat(result == null, Matchers.`is`(true))
    }
}
