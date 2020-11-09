package zhewuzhou.me.string

import java.util.*

fun removeDuplicateLetters(s: String): String {
    if (s.isEmpty() || s.length == 1) return s
    val charPos = TreeMap<Char, Int>()
    fun remove(start: Int, letters: MutableSet<Char>): String {
        if (letters.size == 1) return "${letters.first()}"
        charPos.clear()
        for (i in start..(s.length - letters.size)) {
            if (!charPos.containsKey(s[i]) && letters.contains(s[i])) {
                charPos[s[i]] = i
            }
        }
        var chosenChar = letters.first()
        var chosenPos = -1
        for (c in charPos.keys) {
            val pos = charPos[c]!!
            val leftChars = mutableSetOf(c)
            for (i in (pos + 1)..s.lastIndex) {
                if (letters.contains(s[i])) {
                    leftChars.add(s[i])
                }
            }
            if (leftChars == letters) {
                letters.remove(c)
                chosenChar = c
                chosenPos = pos + 1
                break
            }
        }
        return "$chosenChar" + remove(chosenPos, letters)
    }
    return remove(0, s.toList().toMutableSet())
}
