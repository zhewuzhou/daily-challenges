package zhewuzhou.me.expr

import java.util.*

/*
1. It seems like simple split will not works for !(f,t,(f,t))
2. Do we need a context?
3. It can be nested expr such as (f,t,(f,t,f,(t,f)))
4. Techniques: on-stack replacement
 */
fun parseBoolExpr(expr: String): Boolean {
    if (expr.length == 1) {
        return expr == "t"
    }
    return when (expr[0]) {
        '!' -> parseNot(expr)
        '|' -> parseOr(expr)
        else -> parseAnd(expr)
    }
}

private fun parseAnd(expr: String): Boolean {
    return evalNestedExpr(expr).all { it == 't' }
}

private fun parseNot(expr: String): Boolean {
    return !parseBoolExpr(expr.substring(2, expr.lastIndex))
}

private fun parseOr(expr: String): Boolean {
    return evalNestedExpr(expr).any { it == 't' }
}

private fun evalNestedExpr(expr: String): List<Char> {
    val eval = Stack<Char>()
    for (i in 2 until expr.lastIndex) {
        if (expr[i] == ')') {
            var subExpr = ")"
            while (eval.isNotEmpty() && eval.peek() != '(') {
                subExpr += eval.pop()
            }
            subExpr += eval.pop()
            subExpr += eval.pop()
            eval.push(if (parseBoolExpr(subExpr.reversed())) 't' else 'f')
        } else {
            eval.push(expr[i])
        }
    }
    return eval.filter { it != ',' }
}