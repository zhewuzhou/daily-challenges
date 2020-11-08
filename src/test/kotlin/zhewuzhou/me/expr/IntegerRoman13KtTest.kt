package zhewuzhou.me.expr

import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class IntegerRoman13KtTest {
    @Test
    fun `Should convert small number to Roman number`() {
        MatcherAssert.assertThat(intToRoman(3), CoreMatchers.`is`("III"))
        MatcherAssert.assertThat(intToRoman(4), CoreMatchers.`is`("IV"))
        MatcherAssert.assertThat(intToRoman(9), CoreMatchers.`is`("IX"))
    }

    @Test
    fun `Should convert large number to Roman number`() {
        MatcherAssert.assertThat(intToRoman(58), CoreMatchers.`is`("LVIII"))
        MatcherAssert.assertThat(intToRoman(1994), CoreMatchers.`is`("MCMXCIV"))
    }

    @Test
    fun `Should convert large roman number to int`() {
        MatcherAssert.assertThat(romanToInt("LVIII"), CoreMatchers.`is`(58))
        MatcherAssert.assertThat(romanToInt("MCMXCIV"), CoreMatchers.`is`(1994))
    }

    @Test
    fun `Should throw exception for edge cases`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            romanToInt("LVIIIM")
        }
    }
}