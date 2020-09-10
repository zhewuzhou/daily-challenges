package zhewuzhou.me.dp

import java.util.*
import java.util.function.Consumer

fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
    val wordLen = beginWord.length
    val allComboDict: MutableMap<String, MutableList<String>> = HashMap()
    wordList.forEach(
        Consumer { word: String ->
            for (i in 0 until wordLen) {
                val newWord = word.substring(0, i) + '*' + word.substring(i + 1, wordLen)
                val transformations = allComboDict.getOrDefault(newWord, ArrayList())
                transformations.add(word)
                allComboDict[newWord] = transformations
            }
        })

    val queue = LinkedList<Pair<String, Int>>()
    queue.add(Pair(beginWord, 1))
    val visited = mutableMapOf<String, Boolean>()
    visited[beginWord] = true
    while (!queue.isEmpty()) {
        val node = queue.remove()
        val word: String = node.first
        val level: Int = node.second
        for (i in 0 until wordLen) {
            val newWord = word.substring(0, i) + '*' + word.substring(i + 1, wordLen)
            for (adjacentWord in allComboDict.getOrDefault(newWord, ArrayList())) {
                if (adjacentWord == endWord) {
                    return level + 1
                }
                if (!visited.containsKey(adjacentWord)) {
                    visited[adjacentWord] = true
                    queue.add(Pair(adjacentWord, level + 1))
                }
            }
        }
    }
    return 0
}



