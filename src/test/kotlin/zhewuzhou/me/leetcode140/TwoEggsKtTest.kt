package zhewuzhou.me.leetcode140

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class TwoEggsKtTest {
    private companion object {
        @JvmStatic
        fun eggCases() = Arrays.stream(
            arrayOf(
                Triple(1, 100, 100),
                Triple(2, 100, 15),
                Triple(3, 100, 10),
                Triple(4, 100, 9),
                Triple(5, 100, 8),
                Triple(20, 100, 8),
                Triple(200, 100, 8)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("eggCases")
    fun `Throw egg problem solve with DP`(case: Triple<Int, Int, Int>) {
        assertThat(eggThrow(case.first, case.second), `is`(case.third))
    }

    @Test
    fun `Should throw exception given egg is smaller than 1`() {
        Assertions.assertThrows(IllegalStateException::class.java) {
            eggThrow(0, 100)
        }
    }

    @Test
    fun `Should throw exception given level is smaller than 1`() {
        Assertions.assertThrows(IllegalStateException::class.java) {
            eggThrow(10, 0)
        }
    }

}
