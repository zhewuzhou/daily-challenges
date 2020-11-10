package zhewuzhou.me.string

/*
1 <= words.length <= 5000
0 <= words[i] <= 300
words[i] consists of lower-case English letters.

A native solution is very easy which is n^2*k

If we using tries:
let say for string "abcd" | "cba", "dcb", "dcba", "dcba" are the strings that makes palindrome
 */

fun palindromePairs(words: Array<String>): List<List<Int>> {
    val allWords = words.mapIndexed { i, v -> v to i }.toMap()
    val result = mutableSetOf<List<Int>>()
    for (i in words.indices) {
        //checks for whole word
        val wIndex = allWords[words[i].reversed()]
        if (wIndex != null && wIndex != i) {
            result.add(listOf(i, wIndex))
            result.add(listOf(wIndex, i))
        }
        //check prefixes
        for (j in 0..words[i].lastIndex) {
            if (isPalindrome(words[i], 0, j)) {
                val pIndex = allWords[words[i].substring(j + 1).reversed()]
                if (pIndex != null) result.add(listOf(pIndex, i))
            }
        }
        //check after fix
        for (k in words[i].lastIndex downTo 0) {
            if (isPalindrome(words[i], k, words[i].lastIndex)) {
                val aIndex = allWords[words[i].substring(0, k).reversed()]
                if (aIndex != null) result.add(listOf(i, aIndex))
            }
        }

    }
    return result.toList()
}

fun isPalindrome(s: String, from: Int, to: Int): Boolean {
    var f = from
    var t = to
    while (t > f) {
        if (s[f++] != s[t--]) return false
    }
    return true
}
