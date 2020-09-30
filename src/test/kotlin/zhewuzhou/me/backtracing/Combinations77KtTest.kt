package zhewuzhou.me.backtracing

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

class Combinations77KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(10, 3, 120),
                Triple(10, 4, 210),
                Triple(4, 2, 6),
                Triple(1, 1, 1)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate combinations of given array`(case: Triple<Int, Int, Int>) {
        assertThat(combine(case.first, case.second).size, `is`(case.third))
    }
}
