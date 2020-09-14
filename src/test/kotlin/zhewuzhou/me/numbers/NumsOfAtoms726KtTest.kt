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
                Pair("K4(ON(SO3)2)2", "K4N2O14S4"),
                Pair("((N42)24(OB40Li30CHe3O48LiNN26)33(C12Li48N30H13HBe31)21(BHN30Li26BCBe47N40)15(H5)16)14", "B18900Be18984C4200H5446He1386Li33894N50106O22638"),
                Pair("K4(ON(SO3)2(Na2O)3)2", "K4N2Na12O20S4")
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

        @JvmStatic
        fun simpleFormulaCases() = Arrays.stream(
            arrayOf(
                Pair("H", mapOf("H" to 1)),
                Pair("HO", mapOf("H" to 1, "O" to 1)),
                Pair("H2MgO2H2Mg2", mapOf("H" to 4, "O" to 2, "Mg" to 3))
            )
        )
    }

    @ParameterizedTest
    @MethodSource("formulaCases")
    fun `Should find all the numbers of atoms`(case: Pair<String, String>) {
        assertThat(countOfAtoms(case.first), `is`(case.second))
    }
}
