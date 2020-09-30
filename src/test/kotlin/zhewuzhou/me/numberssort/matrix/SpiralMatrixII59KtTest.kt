package zhewuzhou.me.numberssort.matrix

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class SpiralMatrixII59KtTest {

    @Test
    fun generateMatrix() {
        val generateMatrix = generateMatrix(3)
        assertThat(generateMatrix.size, `is`(3))
        assertThat(generateMatrix[0].size, `is`(3))
    }
}
