package zhewuzhou.me.numberssort.matrix

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*


class Search2DMatrix74KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(arrayOf(
                    intArrayOf(1, 3, 5, 7),
                    intArrayOf(10, 11, 16, 20),
                    intArrayOf(23, 30, 34, 50)
                ), 3, true),
                Triple(arrayOf(
                    intArrayOf(1, 3, 5, 7),
                    intArrayOf(10, 11, 16, 20),
                    intArrayOf(23, 30, 34, 50)
                ), 13, false),
                Triple(arrayOf(
                    intArrayOf(1, 3, 5, 7),
                    intArrayOf(10, 11, 16, 20),
                    intArrayOf(23, 30, 34, 50)
                ), 35, false),
                Triple(arrayOf(
                    intArrayOf(1, 3, 5, 7),
                    intArrayOf(10, 11, 16, 20),
                    intArrayOf(23, 30, 34, 50)
                ), 51, false),
                Triple(arrayOf(
                    intArrayOf(-50, 3, 5, 7),
                    intArrayOf(10, 11, 16, 20),
                    intArrayOf(23, 30, 34, 50)
                ), 51, false),
                Triple(arrayOf(
                    intArrayOf(1, 3)
                ), 3, true),
                Triple(arrayOf(
                    intArrayOf(1),
                    intArrayOf(3)
                ), 3, true)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find the target value in matrix`(case: Triple<Array<IntArray>, Int, Boolean>) {
        assertThat(searchMatrix(case.first, case.second), `is`(case.third))
    }
}
