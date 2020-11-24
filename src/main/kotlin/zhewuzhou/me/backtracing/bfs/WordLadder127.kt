package zhewuzhou.me.backtracing.bfs

import java.util.*

/*
* In this Case BFS guide to shortest path:
* 1. If you have found solution in the early level, there is no need to go further
* 2. Each of char could be used only once, or else there is shorter path
* 3. DFS is not effective in this situation, for a pattern such as x->y->z that have no path,
*    DFS can not tell is has been visited
*/
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



