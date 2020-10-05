package zhewuzhou.me.leetcode120

import zhewuzhou.utils.TreeNode
import java.util.*

fun levelOrder(root: TreeNode?): List<List<Int>> {
    return travel(root, false)
}

private fun travel(root: TreeNode?, isZigZag: Boolean): List<List<Int>> {
    if (root == null) return listOf()
    var zigzag = isZigZag
    val queue = LinkedList<TreeNode>()
    queue.add(root)
    val res = mutableListOf(listOf(root.`val`))
    while (queue.isNotEmpty()) {
        val level = mutableListOf<TreeNode>()
        while (queue.isNotEmpty()) {
            val ele = queue.pop()
            if (ele.left != null) {
                level.add(ele.left!!)
            }
            if (ele.right != null) {
                level.add(ele.right!!)
            }
        }
        if (level.isNotEmpty()) {
            if (isZigZag && zigzag) {
                res.add(level.reversed().map { it.`val` })
            } else {
                res.add(level.map { it.`val` })
            }
            queue.addAll(level)
        }
        if (isZigZag) zigzag = !zigzag
    }
    return res
}

fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
    return travel(root, true)
}
