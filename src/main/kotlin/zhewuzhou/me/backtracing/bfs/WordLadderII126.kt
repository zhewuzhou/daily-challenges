package zhewuzhou.me.backtracing.bfs

import java.util.*


fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
    val wordSet: MutableSet<String> = HashSet(wordList)
    if (!wordSet.contains(endWord)) return ArrayList()
    var layer = mutableMapOf(
        beginWord to mutableListOf(mutableListOf(beginWord))
    )
    while (layer.isNotEmpty()) {
        val newLayer = mutableMapOf<String, MutableList<MutableList<String>>>()
        for (word in layer.keys) {
            if (word == endWord) {
                return layer[word]!!
            }
            for (i in word.indices) {
                for (c in 'a'..'z') {
                    val newWord = word.substring(0, i) + c + word.substring(i + 1)
                    if (!wordSet.contains(newWord)) continue
                    if (!newLayer.containsKey(newWord)) {
                        newLayer[newWord] = mutableListOf()
                    }
                    for (list in layer[word]!!) {
                        val newList = mutableListOf(*list.toTypedArray())
                        newList.add(newWord)
                        newLayer[newWord]!!.add(newList)
                    }
                }
            }
        }
        layer = newLayer
        for (str in newLayer.keys) {
            wordSet.remove(str)
        }
    }
    return ArrayList()
}
