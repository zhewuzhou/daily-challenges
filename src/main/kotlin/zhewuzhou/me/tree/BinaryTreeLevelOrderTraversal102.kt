package zhewuzhou.me.tree

import zhewuzhou.utils.TreeNode
import java.util.*

/**
 * Lambda can really make code simple
 */

fun levelOrder(root: TreeNode?): List<List<Int>> {
    return travel(root)
}

fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
    return travel(root) { apply -> if (apply) reversed() else toList() }
}

private fun travel(root: TreeNode?,
                   action: List<Int>.(apply: Boolean) -> List<Int> = { _: Boolean -> toList() }): List<List<Int>> {
    if (root == null) return listOf()
    val queue = LinkedList<TreeNode>()
    queue.offer(root)
    var level = 1
    val res = mutableListOf<List<Int>>()
    while (queue.isNotEmpty()) {
        val levelNodesCount = queue.lastIndex
        val levelNodes = mutableListOf<Int>()
        for (i in 0..levelNodesCount) {
            val n = queue.poll()
            levelNodes.add(n.`val`)
            if (n.left != null) queue.offer(n.left)
            if (n.right != null) queue.offer(n.right)
        }
        res.add(levelNodes.action(level % 2 == 0))
        level += 1
    }
    return res
}

