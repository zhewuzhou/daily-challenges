package zhewuzhou.me.leetcode320

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
        var chosen = letters.first()
        for (c in charPos.keys) {
            val leftChars = s.substring(charPos[c]!!)
                .toList()
                .filter { letters.contains(it) }
                .toSet()
            if (leftChars == letters) {
                letters.remove(c)
                chosen = c
                break
            }
        }
        return "$chosen" + remove(charPos[chosen]!! + 1, letters)
    }
    return remove(0, s.toList().toMutableSet())
}
