package zhewuzhou.me.string

import org.hamcrest.MatcherAssert
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

internal class NumberOfPairs2023KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
                arrayOf(
                        Triple(arrayOf("777", "7", "77", "77"), "7777", 4),
                        Triple(arrayOf("123", "4", "12", "34"), "1234", 2),
                        Triple(arrayOf("1", "1", "1"), "11", 6),
                        Triple(arrayOf("1", "111"), "11", 0),
                        Triple(arrayOf("1", "1", "1"), "", 0),
                        Triple(arrayOf("1"), "111", 0),
                        Triple(arrayOf("1"), "111", 0),
                        Triple(arrayOf(), "111", 0))
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should calculate num of pairs`(case: Triple<Array<String>, String, Int>) {
        assertThat(numOfPairs(case.first, case.second), `is`(case.third))
    }
}