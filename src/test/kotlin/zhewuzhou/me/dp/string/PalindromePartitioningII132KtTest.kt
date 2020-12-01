package zhewuzhou.me.dp.string

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class PalindromePartitioningII132KtTest {
    private companion object {
        @JvmStatic
        fun minCutCases() = Arrays.stream(
                arrayOf(
                        Pair("aab", 1),
                        Pair("a", 0),
                        Pair("aba", 0),
                        Pair("aaaaaaaaaaaaaaaaaaaaaaaaabbbbb", 1),
                        Pair("apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp", 452),
                        Pair("fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi", 75)

                )
        )
    }

    @ParameterizedTest
    @MethodSource("minCutCases")
    fun `Should calculate min cut`(case: Pair<String, Int>) {
        assertThat(minCut(case.first), `is`(case.second))
    }
}
