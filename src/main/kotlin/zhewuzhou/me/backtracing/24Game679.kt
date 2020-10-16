package zhewuzhou.me.backtracing


fun judgePoint24(nums: IntArray): Boolean {
    val EPSILON = 0.001
    val ops = listOf(
        Double::plus,
        Double::minus,
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

fun judgePoint24Comb(nums: IntArray): List<String> {
    val EPSILON = 0.001
    val ops = mapOf(
        "+" to Double::plus,
        "-" to Double::minus,
        "/" to Double::div,
        "*" to Double::times,
        "--" to fun(a: Double, b: Double) = b - a,
        "//" to fun(a: Double, b: Double) = b / a
    )

    fun backtrace(stack: List<Double>, res: MutableList<String>, steps: MutableList<String>) {
        if (stack.size == 1) {
            if (Math.abs(stack[0] - 24.0) < EPSILON) {
                res.add(steps.joinToString("->"))
            }
            return
        }
        for (i in stack.indices) {
            for (j in (i + 1)..stack.lastIndex) {
                for (key in ops.keys) {
                    val nextRoundStack = mutableListOf<Double>()
                    nextRoundStack.add(ops[key]!!(stack[i], stack[j]))
                    if (key.length == 1) {
                        steps.add("Step: $stack: $i $key $j")
                    } else {
                        steps.add("Step: $stack: $j ${key[0]} $i")
                    }
                    for (k in stack.indices) {
                        if (k == j || k == i) continue
                        nextRoundStack.add(stack[k])
                    }
                    backtrace(nextRoundStack, res, steps)
                    steps.removeAt(steps.lastIndex)
                }
            }
        }
    }

    val res = mutableListOf<String>()
    backtrace(nums.map { it.toDouble() }, res, mutableListOf())
    return res
}
