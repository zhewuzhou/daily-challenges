package zhewuzhou.me.tree

import zhewuzhou.utils.TreeNode
import java.util.*

fun isSymmetric(root: TreeNode?): Boolean {
    fun isSymmetric(lhs: TreeNode?, rhs: TreeNode?): Boolean {
        if (lhs == null && rhs == null) return true
        if (lhs != null && rhs != null) {
            val rootEqual = (lhs.`val` == rhs.`val`)
            return rootEqual &&
                isSymmetric(lhs.left, rhs.right) &&
                isSymmetric(lhs.right, rhs.left)
        }
        return false
    }
    if (root == null) return true
    return isSymmetric(root.left, root.right)
}

fun isSymmetricStack(root: TreeNode?): Boolean {
    fun stackTravel(lhs: TreeNode?, rhs: TreeNode?): Boolean {
        val ls: Stack<TreeNode> = Stack()
        val rs: Stack<TreeNode> = Stack()
        var lc = lhs
        var rc = rhs
        while ((lc != null || ls.isNotEmpty()) || (rc != null || rs.isNotEmpty())) {
            if (lc?.`val` != rc?.`val`) return false
            while (lc != null) {
                ls.add(lc)
                lc = lc.left
            }
            while (rc != null) {
                rs.add(rc)
                rc = rc.right
            }
            if (ls.map { it.`val` } != rs.map { it.`val` }) return false
            lc = ls.pop()
            rc = rs.pop()
            lc = lc.right
            rc = rc.left
        }
        return true
    }

    val lhs = root?.left
    val rhs = root?.right
    if (lhs == null && rhs == null) return true
    if (lhs == null || rhs == null) return false
    return stackTravel(root.left, root.right)
}
