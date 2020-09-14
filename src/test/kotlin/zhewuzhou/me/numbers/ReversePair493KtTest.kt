package zhewuzhou.me.numbers

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

/*
1. if i < j and nums[i] > 2*nums[j], so called important reverse pair
2. array length < 50000
3. all int 32 bits

Questions:
1. What about the negative num?
2. What are those numbers such as 5000/32 meanings?

Brutal solution is very easy which takes O2
With merge sort it could be Onlogn
 */

internal class ReversePair493KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(intArrayOf(1, 3, 2, 3, 1), 2),
                Pair(intArrayOf(2, 4, 3, 5, 1), 3)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find the number of reverse pair in the array`(case: Pair<IntArray, Int>) {
        assertThat(reversePairs(case.first), `is`(case.second))
    }
}
