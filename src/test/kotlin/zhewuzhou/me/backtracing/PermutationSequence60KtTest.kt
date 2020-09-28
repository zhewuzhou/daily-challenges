package zhewuzhou.me.backtracing

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class PermutationSequence60KtTest {
    @Test
    fun getPermutation() {
        assertThat(getPermutation(3, 3), `is`("213"))
        assertThat(getPermutation(4, 9), `is`("2314"))
    }
}
