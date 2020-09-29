package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class UniquePaths62KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(3, 7, 28),
                Triple(3, 2, 3),
                Triple(7, 3, 28),
                Triple(3, 3, 6)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find all unique paths`(case: Triple<Int, Int, Int>) {
        assertThat(uniquePaths(case.first, case.second), `is`(case.third))
    }
}
