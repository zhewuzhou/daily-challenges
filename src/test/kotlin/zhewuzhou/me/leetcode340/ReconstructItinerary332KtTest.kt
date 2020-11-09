package zhewuzhou.me.leetcode340

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import zhewuzhou.me.backtracing.findItinerary
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
                    Pair(listOf(listOf("SFO", "ALT")), listOf()),
                Pair(listOf(
                    listOf("EZE", "TIA"),
                    listOf("EZE", "HBA"),
                    listOf("AXA", "TIA"),
                    listOf("JFK", "AXA"),
                    listOf("ANU", "JFK"),
                    listOf("ADL", "ANU"),
                    listOf("TIA", "AUA"),
                    listOf("ANU", "AUA"),
                    listOf("ADL", "EZE"),
                    listOf("ADL", "EZE"),
                    listOf("EZE", "ADL"),
                    listOf("AXA", "EZE"),
                    listOf("AUA", "AXA"),
                    listOf("JFK", "AXA"),
                    listOf("AXA", "AUA"),
                    listOf("AUA", "ADL"),
                    listOf("ANU", "EZE"),
                    listOf("TIA", "ADL"),
                    listOf("EZE", "ANU"),
                    listOf("AUA", "ANU")),
                    listOf("JFK", "AXA", "AUA", "ADL", "ANU", "AUA", "ANU", "EZE", "ADL", "EZE",
                        "ANU", "JFK", "AXA", "EZE", "TIA", "AUA", "AXA", "TIA", "ADL", "EZE", "HBA"))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should reconstruct the itinerary`(case: Pair<List<List<String>>, List<String>>) {
        assertThat(findItinerary(case.first), `is`(case.second))
    }
}
