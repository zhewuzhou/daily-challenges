package zhewuzhou.me.backtracing.dfs

import zhewuzhou.me.datastructure.WordDictionary
import zhewuzhou.me.datastructure.WordDictionary.TrieNode

fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
    fun dfs(row: Int, col: Int, p: TrieNode, result: MutableSet<String>) {
        val c = board[row][col]
        val n = (if (c == '#') null else p.children[c - 'a']) ?: return
        board[row][col] = '#'
        val word = n.word
        if (word != null) {
            result.add(word)
        }
        if (row > 0) dfs(row - 1, col, n, result)
        if (row < board.lastIndex) dfs(row + 1, col, n, result)
        if (col > 0) dfs(row, col - 1, n, result)
        if (col < board[0].lastIndex) dfs(row, col + 1, n, result)
        board[row][col] = c
    }

    if (board.isEmpty() || board[0].isEmpty()) return listOf()
    val trie = WordDictionary()
    for (w in words) {
        trie.addWord(w)
    }

    val result = mutableSetOf<String>()
    for (i in board.indices) {
        for (j in board[0].indices) {
            dfs(i, j, trie.root, result)
        }
    }
    return result.toList()
}
