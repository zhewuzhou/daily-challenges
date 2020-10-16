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

    fun backtrace(stack: List<Double>, res: MutableList<String>, exps: List<String>) {
        if (stack.size == 1) {
            if (Math.abs(stack[0] - 24.0) < EPSILON) {
                println(exps)
                res.add(exps[0])
            }
            return
        }
        for (i in stack.indices) {
            for (j in (i + 1)..stack.lastIndex) {
                for (key in ops.keys) {
                    val nextRoundStack = mutableListOf<Double>()
                    val nextRoundExps = mutableListOf<String>()
                    nextRoundStack.add(ops[key]!!(stack[i], stack[j]))
                    nextRoundExps.add(
                        if (key.length == 1) {
                            "(${exps[i]} $key ${exps[j]})"
                        } else {
                            "(${exps[j]} ${key[0]} ${exps[i]})"
                        }
                    )
                    for (k in stack.indices) {
                        if (k == j || k == i) continue
                        nextRoundStack.add(stack[k])
                        nextRoundExps.add(exps[k])
                    }
                    backtrace(nextRoundStack, res, nextRoundExps)
                }
            }
        }
    }

    val res = mutableListOf<String>()
    backtrace(nums.map { it.toDouble() }, res, nums.map { it.toString() })
    return res
}
