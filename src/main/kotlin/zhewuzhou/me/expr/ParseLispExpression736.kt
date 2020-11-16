package zhewuzhou.me.expr

import java.util.*


/*
1. The given string expression is well formatted
2. The length of expression is at most 2000, and non-empty
3. 32 bits of int
4. let is very different it's the context such that ctx will be consumed later
 */
fun evaluate(expression: String): Int {
    return eval(expression, HashMap())
}

private fun eval(expr: String, ctx: Map<String, Int>): Int {
    if (expr[0] != '(') {
        return when {
            isNumber(expr[0]) -> expr.toInt()
            else -> ctx[expr]!!
        }
    }

    val curCtx = mutableMapOf<String, Int>()
    curCtx.putAll(ctx)
    val tokens = tokenizer(expr.substring(if (expr[1] == 'm') 6 else 5, expr.length - 1))
    return when {
        expr.startsWith("(a") -> {
            eval(tokens[0], curCtx) + eval(tokens[1], curCtx)
        }
        expr.startsWith("(m") -> {
            eval(tokens[0], curCtx) * eval(tokens[1], curCtx)
        }
        else -> {
            var i = 0
            while (i < tokens.size - 2) {
                curCtx[tokens[i]] = eval(tokens[i + 1], curCtx)
                i += 2
            }
            eval(tokens[tokens.size - 1], curCtx)
        }
    }
}

private fun isNumber(start: Char) = start == '-' || start.isDigit()

private fun tokenizer(src: String): List<String> {
    val tokens: MutableList<String> = ArrayList()
    var count = 0
    var sb = StringBuilder()
    for (c in src.toCharArray()) {
        if (c == '(') count++
        if (c == ')') count--
        if (count == 0 && c == ' ') {
            tokens.add(String(sb))
            sb = StringBuilder()
        } else {
            sb.append(c)
        }
    }
    if (sb.isNotEmpty()) tokens.add(String(sb))
    return tokens
}
