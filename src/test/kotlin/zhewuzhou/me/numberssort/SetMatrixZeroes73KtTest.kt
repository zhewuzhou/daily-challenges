package zhewuzhou.me.numberssort

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class SetMatrixZeroes73KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(arrayOf(
                    intArrayOf(1, 1, 1),
                    intArrayOf(1, 0, 1),
                    intArrayOf(1, 1, 1)
                ), arrayOf(
                    listOf(1, 0, 1),
                    listOf(0, 0, 0),
                    listOf(1, 0, 1)
                )),
                Pair(arrayOf(
                    intArrayOf(0, 1, 2, 0),
                    intArrayOf(3, 4, 5, 2),
                    intArrayOf(1, 3, 1, 5)
                ), arrayOf(
                    listOf(0, 0, 0, 0),
                    listOf(0, 4, 5, 0),
                    listOf(0, 3, 1, 0)
                ))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should set zeros correctly`(case: Pair<Array<IntArray>, Array<List<Int>>>) {
        val result = case.first
        val expect = case.second
        setZeroes(result)
        assertThat(result.size, `is`(expect.size))
        for (i in result.indices) {
            assertThat(result[i].toList(), `is`(expect[i]))
        }
    }
}
