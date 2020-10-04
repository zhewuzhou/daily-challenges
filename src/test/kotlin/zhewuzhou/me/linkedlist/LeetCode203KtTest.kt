package zhewuzhou.me.linkedlist

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.utils.toListNode
import java.util.*

internal class LeetCode203KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(listOf(1, 2, 6, 3, 4, 5, 6), 6, listOf(1, 2, 3, 4, 5)),
                Triple(listOf(6, 6, 6, 6, 6, 6, 6), 6, listOf()),
                Triple(listOf(), 100, listOf())
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should remove all elements`(case: Triple<List<Int>, Int, List<Int>>) {
        var head = removeElements(case.first.toListNode(), case.second)
        if (case.third.isEmpty()) {
            assertThat(head == null, `is`(true))
        }
        for (v in case.third) {
            assertThat(head!!.`val`, `is`(v))
            head = head.next
        }
    }
}
