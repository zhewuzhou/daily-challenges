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

    fun preorderTraversal(): List<Int>? {
        val result: MutableList<Int> = ArrayList()
        val stack = Stack<TreeNode>()
        var p: TreeNode? = this
        while (!stack.isEmpty() || p != null) {
            p = if (p != null) {
                stack.push(p)
                result.add(p.`val`) // Add before going to children
                p.left
            } else {
                val node: TreeNode = stack.pop()
                node.right
            }
        }
        return result
    }

    fun inorderTraversal(): List<Int>? {
        val result: MutableList<Int> = ArrayList()
        val stack = Stack<TreeNode>()
        var p: TreeNode? = this
        while (!stack.isEmpty() || p != null) {
            p = if (p != null) {
                stack.push(p)
                p.left
            } else {
                val node = stack.pop()
                result.add(node.`val`) // Add after all left children
                node.right
            }
        }
        return result
    }

    fun postorderTraversal(): List<Int>? {
        val result = LinkedList<Int>()
        val stack = Stack<TreeNode>()
        var p: TreeNode? = this
        while (!stack.isEmpty() || p != null) {
            p = if (p != null) {
                stack.push(p)
                result.addFirst(p.`val`) // Reverse the process of preorder
                p.right // Reverse the process of preorder
            } else {
                val node = stack.pop()
                node.left // Reverse the process of preorder
            }
        }
        return result
    }

    fun treeToList(): List<Int> {
        val res = mutableListOf<Int>()
        var root: TreeNode? = this
        val queue = LinkedList<TreeNode>()
        queue.offer(root)
        while (queue.isNotEmpty()) {
            root = queue.poll()
            res.add(root.`val`)
            if (root.`val` != NullNode) {
                if (root.left != null) {
                    queue.offer(root.left)
                } else {
                    queue.offer(TreeNode(NullNode))
                }
                if (root.right != null) {
                    queue.offer(root.left)
                } else {
                    queue.offer(TreeNode(NullNode))
                }
            }
        }
        var i = res.lastIndex
        while (res[i] == NullNode) {
            res.removeAt(i)
            i -= 1
        }
        return res
    }
}

fun List<Int>.toTree(): TreeNode? {
    if (isEmpty()) return null
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
