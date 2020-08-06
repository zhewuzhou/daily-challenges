package zhewuzhou.me.leetcode300

import java.util.*


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

fun addOperators(num: String, target: Int): List<String> {
    val res: MutableList<String> = ArrayList()
    if (num.isEmpty()) return res
    addOperator(res, num, target, "", 0, 0, 0)
    return res
}

/* A nice trick here variable forMul is used for the future next multiplication */
private fun addOperator(res: MutableList<String>, num: String, target: Int, path: String, eval: Long, forMul: Long, index: Int) {
    if (index == num.length) {
        if (eval == target.toLong()) {
            res.add(path)
        }
    } else {
        for (i in index..num.lastIndex) {
            if (i != index && num[index] == '0') break /* prevent number with leading zero */
            val cur = num.substring(index, i + 1).toLong()
            if (index == 0) {
                addOperator(res, num, target, path + cur, cur, cur, i + 1)
            } else {
                addOperator(res, num, target, "$path+$cur", eval + cur, cur, i + 1)
                addOperator(res, num, target, "$path-$cur", eval - cur, -cur, i + 1)
                addOperator(res, num, target, "$path*$cur", eval - forMul + forMul * cur, forMul * cur, i + 1)
            }
        }
    }
}
