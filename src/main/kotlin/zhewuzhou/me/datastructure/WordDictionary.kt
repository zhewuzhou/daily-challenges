package zhewuzhou.me.datastructure

class WordDictionary {
    data class TrieNode(val v: Char) {
        val children: Array<TrieNode?> = Array(26) { null }
        var word: String? = null
    }

    val root = TrieNode(' ')

    fun addWord(word: String) {
        var cur = root
        for (c in word) {
            if (cur.children[c - 'a'] != null) {
                cur = cur.children[c - 'a']!!
            } else {
                val t = TrieNode(c)
                cur.children[c - 'a'] = t
                cur = t
            }
        }
        cur.word = word
    }

    fun search(word: String): Boolean {
        fun doSearch(cur: TrieNode, count: Int): Boolean {
            if (count == word.length) {
                return cur.word != null
            } else {
                if (word[count] == '.') {
                    for (n in cur.children) {
                        if (n != null) {
                            if (doSearch(n, count + 1)) {
                                return true
                            }
                        }
                    }
                } else {
                    val n = cur.children[word[count] - 'a']
                    return if (n == null) false else doSearch(n, count + 1)
                }
            }
            return false
        }
        return doSearch(root, 0)
    }
}
