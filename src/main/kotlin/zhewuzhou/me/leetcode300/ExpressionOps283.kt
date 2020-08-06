package zhewuzhou.me.leetcode300

fun addOperators(nums: String, target: Int): List<String> {
    val result = mutableSetOf<String>()
    fun doAdd(curExp: MutableList<Char>, start: Int) {
        val curExpS = curExp.joinToString("")
        if (eval(curExpS) == target) {
            result.add(curExpS)
        }
        if (start < nums.length) {
            for (op in listOf('-', '+', '*')) {
                curExp.add(op)
                curExp.add(nums[start])
                doAdd(curExp, start + 1)
                curExp.remove(curExp.last())
                curExp.remove(curExp.last())
            }
        }
    }
    doAdd(mutableListOf(nums[0]), 1)
    return result.toList()
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
