package zhewuzhou.me.numbers

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

/*
Requirements:
1. Atoms can be single Upper or Upper|lowers
2. The length of input is [1..1000]
3. Formula contains letters/digits/parentheses and always valid
4. Output in sorted order
 */

internal class NumsOfAtoms726KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
                Pair("H2O", "H2O"),
                Pair("Mg(OH)2", "H2MgO2"),
                Pair("K4(ON(SO3)2)2", "K4N2O14S4")
            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should find all the numbers of atoms`(case: Pair<String, String>) {
        assertThat(countOfAtoms(case.first), `is`(case.second))
    }
}
