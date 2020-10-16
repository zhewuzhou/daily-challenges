package zhewuzhou.me.backtracing


fun judgePoint24(nums: IntArray): Boolean {
    val EPSILON = 0.001
    val ops = listOf(
        Double::minus,
        Double::times,
        Double::div,
        Double::times,
        fun(a: Double, b: Double) = b - a,
        fun(a: Double, b: Double) = b / a
    )

    fun backtrace(stack: List<Double>): Boolean {
        if (stack.size == 1) {
            return Math.abs(stack[0] - 24.0) < EPSILON
        }
        for (i in stack.indices) {
            for (j in (i + 1)..stack.lastIndex) {
                for (c in ops.map { it(stack[i], stack[j]) }) {
                    val nextRoundStack = mutableListOf<Double>()
                    nextRoundStack.add(c)
                    for (k in stack.indices) {
                        if (k == j || k == i) continue
                        nextRoundStack.add(stack[k])
                    }
                    if (backtrace(nextRoundStack)) return true
                }
            }
        }
        return false
    }
    return backtrace(nums.map { it.toDouble() })
}
