package zhewuzhou.me.tree

import zhewuzhou.utils.TreeNode
import java.util.*

class BSTIterator(val root: TreeNode?) {
    private val path = Stack<TreeNode>()

    init {
        pushWholeLeftPath(root)
    }

    fun next(): Int {
        if (path.peek().right == null) {
            return path.pop().`val`
        } else {
            val result = path.pop()
            pushWholeLeftPath(result.right)
            return result.`val`
        }
    }

    private fun pushWholeLeftPath(head: TreeNode?) {
        var n = head
        while (n != null) {
            path.push(n)
            n = n.left
        }
    }

    fun hasNext(): Boolean {
        return path.isNotEmpty()
    }
}
