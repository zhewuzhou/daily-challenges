package zhewuzhou.me.dp

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*


internal class KthSmallestInstructions1643KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
                arrayOf(
                        Triple(intArrayOf(2, 3), 1, "HHHVV"),
                        Triple(intArrayOf(2, 3), 2, "HHVHV"),
                        Triple(intArrayOf(2, 3), 3, "HHVVH")
                )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find kth smallest instructions`(case: Triple<IntArray, Int, String>) {
        assertThat(kthSmallestPath(case.first, case.second), `is`(case.third))
    }
}