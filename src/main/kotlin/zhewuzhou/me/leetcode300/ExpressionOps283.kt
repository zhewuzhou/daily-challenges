package zhewuzhou.me.leetcode300

fun addOperatorsSlow(nums: String, target: Int): List<String> {
    if (nums.isEmpty()) return listOf()
    fun calculateExp(s: String): List<String> {
        if (s.length == 1) return listOf(s)
        val res = mutableListOf<String>()
        val exps = calculateExp(s.substring(1))
        val first = s[0].toString()
        val validOps = listOf("", "+", "-", "*")
        for (op in validOps) {
            res.addAll(exps.map { first + op + it })
        }
        return res
    }

    val allValidExp = calculateExp(nums)
        .filter { isValidExp(it) }
    return allValidExp.filter { eval(it) == target.toLong() }

}

fun isValidExp(s: String): Boolean {
    var start = 0
    for (i in s.indices) {
        if (s[i] in '0'..'9') {
            if (i > start && s[start] == '0') return false
        } else {
            start = i + 1
        }
    }
    return true
}

fun eval(s: String): Long {
    val ops = mapOf(
        '*' to fun(a: Long, b: Long) = a * b
    )
    var sign = 1
    var operand = 0L
    var highOrderOp: Char? = null
    var highOrderResult = -1L
    var result = 0L
    for (c in s) {
        when {
            c.isDigit() -> operand = operand * 10 + (c - '0')
            c == '+' || c == '-' -> {
                result += if (highOrderOp != null) {
                    ops[highOrderOp]!!(highOrderResult, operand) * sign
                } else {
                    sign * operand
                }

                sign = if (c == '+') 1 else -1
                highOrderOp = null
                highOrderResult = -1
                operand = 0
            }
            c == '*' -> {
                highOrderResult = if (highOrderResult == -1L) {
                    operand
                } else {
                    ops[highOrderOp]!!(highOrderResult, operand)
                }
                operand = 0
                highOrderOp = c
            }
        }
    }
    if (highOrderResult != -1L) {
        operand = ops[highOrderOp]!!(highOrderResult, operand)
    }
    result += operand * sign
    return result
}
