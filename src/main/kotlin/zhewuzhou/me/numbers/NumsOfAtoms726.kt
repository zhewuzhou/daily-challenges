package zhewuzhou.me.numbers

import java.util.*

fun handleSingleAtom(atom: String): Pair<String, Int> {
    for (i in atom.indices) {
        if (atom[i].isDigit()) {
            return Pair(atom.substring(0, i), atom.substring(i).toInt())
        }
    }
    return Pair(atom, 1)
}


fun handleSimpleFormula(simple: String): Map<String, Int> {
    val res = mutableMapOf<String, Int>()
    val stack = Stack<Int>()
    fun processAtom(start: Int, i: Int) {
        val atom = handleSingleAtom(simple.substring(start, i))
        if (res.containsKey(atom.first)) {
            res[atom.first] = res[atom.first]!! + atom.second
        } else {
            res[atom.first] = atom.second
        }
    }
    for (i in simple.indices) {
        if (simple[i].isUpperCase()) {
            if (stack.isNotEmpty()) {
                processAtom(stack.pop(), i)
            }
            stack.push(i)
        }
        if (i == simple.lastIndex) {
            processAtom(stack.pop(), i + 1)
        }
    }
    return res
}


fun countOfAtoms(formula: String): String {
    return ""
}
