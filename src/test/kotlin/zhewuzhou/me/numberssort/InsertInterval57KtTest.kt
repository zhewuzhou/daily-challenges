package zhewuzhou.me.numberssort

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

class InsertInterval57KtTest {
    private companion object {
        @JvmStatic
        fun lowerCases() = Arrays.stream(
            arrayOf(
                Triple(
                    arrayOf(intArrayOf(1, 3), intArrayOf(6, 9)),
                    2,
                    0
                ),
                Triple(
                    arrayOf(intArrayOf(1, 3)),
                    2,
                    0
                ),
                Triple(
                    arrayOf(intArrayOf(1, 3)),
                    0,
                    0
                ),
                Triple(
                    arrayOf(intArrayOf(1, 3)),
                    3,
                    0
                ),
                Triple(
                    arrayOf(intArrayOf(1, 3)),
                    4,
                    -1
                ),
                Triple(
                    arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(6, 7),
                        intArrayOf(8, 10), intArrayOf(12, 16)),
                    4,
                    1
                ),
                Triple(
                    arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(6, 7),
                        intArrayOf(8, 10), intArrayOf(12, 16)),
                    11,
                    4
                ),
                Triple(
                    arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(6, 7),
                        intArrayOf(8, 10), intArrayOf(12, 16)),
                    0,
                    0
                ),
                Triple(
                    arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(6, 7),
                        intArrayOf(8, 10), intArrayOf(12, 16)),
                    17,
                    -1
                )
            )
        )

        @JvmStatic
        fun upperCases() = Arrays.stream(
            arrayOf(
                Triple(
                    arrayOf(intArrayOf(1, 3)),
                    2,
                    0
                ),
                Triple(
                    arrayOf(intArrayOf(1, 3)),
                    4,
                    0
                ),
                Triple(
                    arrayOf(intArrayOf(1, 3)),
                    3,
                    0
                ),
                Triple(
                    arrayOf(intArrayOf(1, 3)),
                    0,
                    -1
                ),
                Triple(
                    arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(6, 7),
                        intArrayOf(8, 10), intArrayOf(12, 16)),
                    11,
                    3
                ),
                Triple(
                    arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(6, 7),
                        intArrayOf(8, 10), intArrayOf(12, 16)),
                    4,
                    1
                ),
                Triple(
                    arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(6, 7),
                        intArrayOf(8, 10), intArrayOf(12, 16)),
                    0,
                    -1
                ),
                Triple(
                    arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(6, 7),
                        intArrayOf(8, 10), intArrayOf(12, 16)),
                    17,
                    4
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("lowerCases")
    fun `Should search for lower bound`(case: Triple<Array<IntArray>, Int, Int>) {
        assertThat(searchForLowerBound(case.first, case.second), `is`(case.third))
    }

    @ParameterizedTest
    @MethodSource("upperCases")
    fun `Should search for upper bound`(case: Triple<Array<IntArray>, Int, Int>) {
        assertThat(searchForUpperBound(case.first, case.second), `is`(case.third))
    }

    @Test
    fun `Should insert newIntervals`() {
        insert(arrayOf(arrayOf(1, 3).toIntArray(), arrayOf(6, 9).toIntArray()), arrayOf(2, 5).toIntArray())
    }
}
