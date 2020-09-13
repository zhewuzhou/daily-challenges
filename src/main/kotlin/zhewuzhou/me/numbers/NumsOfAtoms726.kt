package zhewuzhou.me.numbers

fun countOfAtoms(formula: String): String {
    return ""
}

fun handleSingleAtom(atom: String): Pair<String, Int> {
    for (i in atom.indices) {
        if (atom[i].isDigit()) {
            return Pair(atom.substring(0, i), atom.substring(i).toInt())
        }
    }
    return Pair(atom, 1)
}
