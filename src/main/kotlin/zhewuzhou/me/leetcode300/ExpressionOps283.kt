package zhewuzhou.me.leetcode300

fun addOperators(nums: String, target: Int): List<String> {
    if (nums.isEmpty()) return listOf()
    val validOps = listOf("", "+", "-", "*")
    fun calculateExp(s: String): List<String> {
        if (s.length == 1) return listOf(s)
        val res = mutableListOf<String>()
        val exps = calculateExp(s.substring(1))
        val first = s[0].toString()
        for (op in validOps) {
            res.addAll(exps.map { first + op + it })
        }
        return res
    }

    val allValidExp = calculateExp(nums)
        .filter { isValidExp(it) }
    return allValidExp.filter { eval(it) == target }

}

fun isValidExp(s: String): Boolean {
    var start = 0
    val validOps = listOf('+', '-', '*')
    for (i in s.indices) {
        if (s[i] in '0'..'9') {
            if (i > start && s[start] == '0') return false
        } else {
            start = i + 1
        }
    }
    return true
}

private fun eval(s: String): Int {
    val ops = mapOf(
        '*' to fun(a: Int, b: Int) = a * b
    )
    var sign = 1
    var operand = 0
    var highOrderOp: Char? = null
    var highOrderResult = -1
    var result = 0
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
                highOrderResult = if (highOrderResult == -1) {
                    operand
                } else {
                    ops[highOrderOp]!!(highOrderResult, operand)
                }
                operand = 0
                highOrderOp = c
            }
        }
    }
    if (highOrderResult != -1) {
        operand = ops[highOrderOp]!!(highOrderResult, operand)
    }
    result += operand * sign
    return result
}
