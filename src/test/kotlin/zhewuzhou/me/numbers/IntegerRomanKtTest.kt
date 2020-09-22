package zhewuzhou.me.numbers

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class IntegerRomanKtTest {

    @Test
    fun `Should convert small number to Roman number`() {
        assertThat(intToRoman(3), `is`("III"))
        assertThat(intToRoman(4), `is`("IV"))
        assertThat(intToRoman(9), `is`("IX"))
    }

    @Test
    fun `Should convert large number to Roman number`() {
        assertThat(intToRoman(58), `is`("LVIII"))
        assertThat(intToRoman(1994), `is`("MCMXCIV"))
    }

    @Test
    fun `Should convert large roman number to int`() {
        assertThat(romanToInt("LVIII"), `is`(58))
        assertThat(romanToInt("MCMXCIV"), `is`(1994))
    }

    @Test
    fun `Should throw exception for edge cases`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            romanToInt("LVIIIM")
        }
    }
}
