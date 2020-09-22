package zhewuzhou.me.simple

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class ZigZagConversion6KtTest {
    private companion object {
        @JvmStatic
        fun convertCases() = Arrays.stream(
            arrayOf(
                Triple("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"),
                Triple("GEEKSFORGEEKS", 3, "GSGSEKFREKEOE"),
                Triple("PAYPALISHIRING", 4, "PINALSIGYAHRPI"),
                Triple("ABCDEFGH", 2, "ACEGBDFH")
            )
        )

        @JvmStatic
        fun indexCases() = Arrays.stream(
            arrayOf(
                Pair(3, listOf(0, 1, 2, 1)),
                Pair(4, listOf(0, 1, 2, 3, 2, 1)),
                Pair(2, listOf(0, 1))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("convertCases")
    fun `Should convert to zigzag format`(case: Triple<String, Int, String>) {
        assertThat(convert(case.first, case.second), `is`(case.third))
    }

    @ParameterizedTest
    @MethodSource("indexCases")
    fun `Should calculate the zigzag index correct`(case: Pair<Int, List<Int>>) {
        assertThat(case.first.zigzagIndex(), `is`(case.second))
    }
}
