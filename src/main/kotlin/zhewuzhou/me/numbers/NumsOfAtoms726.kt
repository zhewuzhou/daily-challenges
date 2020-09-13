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
    val res = TreeMap<String, Int>()
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

fun countOfAtoms(f: String): String {
    val stack = Stack<Char>()
    var cur = 0
    val res = StringBuilder()
    while (cur <= f.length) {
        if (cur == f.length) {
            val atoms = handleSimpleFormula(stack.toCharArray().joinToString(""))
            for (key in atoms.keys) {
                res.append(key)
                if (atoms[key]!! > 1) {
                    res.append(atoms[key]!!)
                }
            }
        } else if (f[cur] == ')') {
            if (cur != f.lastIndex) {
                val start = cur
                while (cur + 1 < f.length && f[cur + 1].isDigit()) {
                    cur += 1
                }
                val factor = if (cur > start) f.substring(start + 1, cur + 1).toInt() else 1
                val simple = LinkedList<Char>()
                while (stack.peek() != '(') {
                    simple.addFirst(stack.pop())
                }
                stack.pop()
                val simpleFormula = simple.joinToString("")
                for (n in 1..factor) {
                    for (c in simpleFormula) {
                        stack.push(c)
                    }
                }
            }
        } else {
            stack.push(f[cur])
        }
        cur += 1
    }
    return res.toString()
}
