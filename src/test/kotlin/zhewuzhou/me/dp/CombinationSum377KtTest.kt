package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class CombinationSum377KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple(intArrayOf(1, 2, 3), 4, 7)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate all possible combinations`(case: Triple<IntArray, Int, Int>) {
        assertThat(combinationSum4(case.first, case.second), `is`(case.third))
    }
}
