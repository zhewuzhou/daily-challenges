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
        fun formulaCases() = Arrays.stream(
            arrayOf(
                Pair("H2O", "H2O"),
                Pair("Mg(OH)2", "H2MgO2"),
                Pair("K4(ON(SO3)2)2", "K4N2O14S4")
            )
        )

        @JvmStatic
        fun atomCases() = Arrays.stream(
            arrayOf(
                Pair("H", Pair("H", 1)),
                Pair("O2", Pair("O", 2)),
                Pair("Mg2", Pair("Mg", 2))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("formulaCases")
    fun `Should find all the numbers of atoms`(case: Pair<String, String>) {
        assertThat(countOfAtoms(case.first), `is`(case.second))
    }

    @ParameterizedTest
    @MethodSource("atomCases")
    fun `Should count single atoms`(case: Pair<String, Pair<String, Int>>) {
        val result = handleSingleAtom(case.first)
        assertThat(result.first, `is`(case.second.first))
        assertThat(result.second, `is`(case.second.second))
    }
}
