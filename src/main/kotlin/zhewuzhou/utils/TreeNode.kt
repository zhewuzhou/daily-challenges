package zhewuzhou.utils

import java.util.*

class TreeNode(var `val`: Int) {
    companion object {
        const val NullNode = Int.MIN_VALUE
        fun treeNodeEqual(lhs: TreeNode?, rhs: TreeNode?): Boolean {
            if (lhs == null && rhs == null) return true
            if (lhs != null && rhs != null) {
                val valueEqual = lhs.`val` == rhs.`val`
                return valueEqual &&
                    treeNodeEqual(lhs.left, rhs.left) &&
                    treeNodeEqual(lhs.right, rhs.right)
            }
            return false
        }
    }

    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun List<Int>.toTree(): TreeNode? {
    var i = 0
    val root = TreeNode(this[0])
    val queue = LinkedList<TreeNode>()
    queue.add(root)
    while ((2 * i + 1) < this.size) {
        if (queue.isNotEmpty()) {
            val cur = queue.poll()
            if (this[2 * i + 1] != TreeNode.NullNode) {
                val left = TreeNode(this[2 * i + 1])
                cur.left = left
                queue.add(left)
            }
            if (this[2 * i + 2] != TreeNode.NullNode) {
                val right = TreeNode(this[2 * i + 2])
                cur.right = right
                queue.add(right)
            }
        }
        i += 1
    }
    return root
}
