package zhewuzhou.me.leetcode340

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class ReconstructItinerary332KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair(listOf(
                    listOf("MUC", "LHR"),
                    listOf("JFK", "MUC"),
                    listOf("SFO", "SJC"),
                    listOf("LHR", "SFO")
                ), listOf("JFK", "MUC", "LHR", "SFO", "SJC")),
                Pair(listOf(
                    listOf("JFK", "SFO"),
                    listOf("JFK", "ATL"),
                    listOf("SFO", "ATL"),
                    listOf("ATL", "JFK"),
                    listOf("ATL", "SFO")
                ), listOf("JFK", "ATL", "JFK", "SFO", "ATL", "SFO")),
                Pair(listOf(), listOf()),
                Pair(listOf(listOf("JFK", "ALT")), listOf("JFK", "ALT")),
                Pair(listOf(listOf("SFO", "ALT")), listOf())
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should reconstruct the itinerary`(case: Pair<List<List<String>>, List<String>>) {
        assertThat(findItinerary(case.first), `is`(case.second))
    }
}
