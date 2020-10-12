package zhewuzhou.me.expr

import java.util.*


fun countOfAtoms(f: String): String {
    val len = f.length
    val stack = Stack<TreeMap<String, Int>>()
    stack.push(TreeMap())
    var cur = 0
    while (cur < len) {
        when {
            f[cur] == '(' -> {
                stack.push(TreeMap())
            }
            f[cur] == ')' -> {
                val top: Map<String, Int> = stack.pop()
                val factor = extractMultiplicity(cur, f)
                val multiplicity = factor.first
                cur = factor.second
                for (k in top.keys) {
                    val v = top[k] ?: error("Impossible")
                    stack.peek()!![k] = stack.peek()!!.getOrDefault(k, 0) + v * multiplicity
                }
            }
            else -> {
                val namePair = extractName(cur, f)
                val name = namePair.first
                cur = namePair.second
                val factor = extractMultiplicity(cur, f)
                stack.peek()[name] = stack.peek().getOrDefault(name, 0) + factor.first
                cur = factor.second
            }
        }
        cur += 1
    }
    return atomsToString(stack.peek())
}

private fun extractName(lowerCaseBefore: Int, f: String): Pair<String, Int> {
    val len = f.length
    var lowerCaseEnd = lowerCaseBefore
    while (lowerCaseEnd + 1 < len && f[lowerCaseEnd + 1].isLowerCase()) {
        lowerCaseEnd += 1
    }
    val name = f.substring(lowerCaseBefore, lowerCaseEnd + 1)
    return Pair(name, lowerCaseEnd)
}

private fun extractMultiplicity(digitBefore: Int, f: String): Pair<Int, Int> {
    val len = f.length
    var digitEnd = digitBefore
    while (digitEnd + 1 < len && f[digitEnd + 1].isDigit()) {
        digitEnd += 1
    }
    val multiplicity = if (digitEnd > digitBefore) f.substring(digitBefore + 1, digitEnd + 1).toInt() else 1
    return Pair(multiplicity, digitEnd)
}

private fun atomsToString(atoms: TreeMap<String, Int>): String {
    val ans = StringBuilder()
    for (name in atoms.keys) {
        ans.append(name)
        val multiplicity = atoms[name]!!
        if (multiplicity > 1) ans.append("" + multiplicity)
    }
    return ans.toString()
}
