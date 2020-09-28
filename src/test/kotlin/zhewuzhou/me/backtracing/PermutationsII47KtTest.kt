package zhewuzhou.me.backtracing

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.me.backtracing.permuteUnique
import java.util.*

internal class PermutationsII47KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(intArrayOf(1, 1, 2), 3),
                Pair(intArrayOf(1, 1, 1), 1),
                Pair(intArrayOf(1, 2, 3), 6)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should return all permutations`(case: Pair<IntArray, Int>) {
        assertThat(permuteUnique(case.first).size, `is`(case.second))
    }
}
