package zhewuzhou.me.numberssort.sort

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

/*
1,2,3,4,5,6
1st loop: 1,2 | 3,4 | 5,6
2rd loop: 1,3 | 2,4 | 5,6  -> 1,3 | 2,6 |54 done

1,2,2,4,5,6
         0,1   2,3   4 5

ab | cd | dx

1,2 | 1,4 | 4,6
4,6 | 1,2 | 1,4
ab | dx | cd
b>d:  -> ab | dx | cd
b<=d: -> dx | ab | cd(b>a && b<=d && x>d => x>a)

1,2 |2 4| 1,3
2,4 |1,2|

13 | 15 | 56
13 | 12 | 24


1st loop: 1,3 | 1,2 | 1,2 | 2,4 | 1,2
1
1,4,2,5,2,6


6,5,4,3,2,1
5,6 | 3,4 | 1,2

1,1,1,4,5,6

Correct: 1,6,2,5,3,4
1,3,2,4: then stop
1->2 and it's can not find any number where smaller than 2
 */
internal class WiggleSort324KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                intArrayOf(1, 5, 1, 1, 6, 4),
                intArrayOf(1, 3, 2, 2, 3, 1),
                intArrayOf(1, 3, 1, 2, 2, 4),
                intArrayOf(1, 2, 1, 4, 4, 6),
                intArrayOf(1, 3, 2, 2, 2, 1, 1, 3, 1, 1, 2)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should sort the array in wiggle style`(case: IntArray) {
        wiggleSort(case)
        var cur = 0
        while (cur < case.lastIndex) {
            assertThat(case[cur] < case[cur + 1], `is`(true))
            if (cur + 2 <= case.lastIndex) {
                assertThat(case[cur + 1] > case[cur + 2], `is`(true))
            }
            cur += 2
        }
    }
}
