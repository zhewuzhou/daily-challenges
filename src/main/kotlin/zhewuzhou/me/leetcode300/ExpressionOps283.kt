package zhewuzhou.me.leetcode300

fun addOperators(nums: String, target: Int): List<String> {
    fun calculateExp(s: String): List<String> {
        if (s.length == 1) {
            return listOf(s)
        }
        val exps = calculateExp(s.substring(1))
        val first = s[0].toString()
        val res = mutableSetOf<String>()
        for (op in listOf("", "+", "-", "*")) {
            if (first == "0" && op == "") continue
            res.addAll(exps.map { first + op + it })
        }
        return res.toList()
    }

    return calculateExp(nums).filter { eval(it) == target }

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
