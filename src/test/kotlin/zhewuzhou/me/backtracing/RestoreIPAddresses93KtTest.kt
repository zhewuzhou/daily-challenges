package zhewuzhou.me.backtracing

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class RestoreIPAddresses93KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair("25525511135", arrayOf("255.255.111.35", "255.255.11.135")),
                Pair("0000", arrayOf("0.0.0.0")),
                Pair("1111", arrayOf("1.1.1.1")),
                Pair("010010", arrayOf("0.10.0.10", "0.100.1.0")),
                Pair("101023", arrayOf("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3"))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate all possibilities`(case: Pair<String, Array<String>>) {
        assertThat(restoreIpAddresses(case.first), containsInAnyOrder(*case.second))
    }
}
