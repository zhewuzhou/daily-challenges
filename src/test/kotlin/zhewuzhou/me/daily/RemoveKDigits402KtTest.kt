package zhewuzhou.me.daily

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class RemoveKDigits402KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Triple("1432219", 3, "1219"),
                Triple("10200", 1, "200"),
                Triple("10", 2, "0"),
                Triple("00000000", 2, "0"),
                Triple("1155511", 3, "1111"),
                Triple("5555555", 3, "5555"),
                Triple("1219", 1, "119"),
                Triple("12139", 2, "113"),
                Triple("1239", 1, "123"),
                Triple("10", 1, "0")
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should be minimum after remove K digits`(case: Triple<String, Int, String>) {
        assertThat(removeKdigits(case.first, case.second), `is`(case.third))
    }

    @Test
    fun `Should remove leading zeros`() {
        assertThat(removeLeadingZeros("0200"), `is`("200"))
        assertThat(removeLeadingZeros("0000"), `is`("0"))
    }
}