package zhewuzhou.me.leetcode340

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

/*
The pre order of the tree is: root -> left -> right
1. Root can not be null
 */

internal class VerifyTree331KtTest {
    private companion object {
        @JvmStatic
        fun cases() = Arrays.stream(
            arrayOf(
//                Pair("9,3,4,#,#,1,#,#,2,#,6,#,#", true),
//                Pair("1,#", false),
//                Pair("9,#,#,1", false),
                Pair("9,#,92,#,#", true)

            )
        )
    }

    @ParameterizedTest
    @MethodSource("cases")
    fun `Should verify if the given string can be tree pre order`(case: Pair<String, Boolean>) {
        assertThat(isValidSerialization(case.first), `is`(case.second))
    }
}
