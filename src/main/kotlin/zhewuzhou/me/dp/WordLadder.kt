package zhewuzhou.me.dp

import java.util.*

fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
    val wordLen = beginWord.length
    val allComboDict = possibleMoveAsWildcard(wordList, wordLen)
    val queue = LinkedList<Pair<String, Int>>()
    queue.add(Pair(beginWord, 1))
    val visited = mutableMapOf<String, Boolean>()
    visited[beginWord] = true
    while (!queue.isEmpty()) {
        val node = queue.remove()
        val word = node.first
        val level = node.second
        for (i in 0 until wordLen) {
            val newWord = word.substring(0, i) + '*' + word.substring(i + 1, wordLen)
            for (next in allComboDict.getOrDefault(newWord, ArrayList())) {
                if (next == endWord) {
                    return level + 1
                }
                if (!visited.containsKey(next)) {
                    visited[next] = true
                    queue.add(Pair(next, level + 1))
                }
            }
        }
    }
    return 0
}

private fun possibleMoveAsWildcard(words: List<String>, wordLen: Int): MutableMap<String, MutableList<String>> {
    val res = mutableMapOf<String, MutableList<String>>()
    words.forEach {
        for (i in 0 until wordLen) {
            val wildcard = it.substring(0, i) + '*' + it.substring(i + 1, wordLen)
            val transforms = res.getOrDefault(wildcard, mutableListOf())
            transforms.add(it)
            res[wildcard] = transforms
        }
    }
    return res
}



