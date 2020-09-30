package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.me.dp.minDistance
import java.util.*

internal class EditDistance72KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple("horse", "ros", 3),
                Triple("intention", "execution", 5)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find the min path from A string to B string`(case: Triple<String, String, Int>) {
        assertThat(minDistance(case.first, case.second), `is`(case.third))
    }
}
