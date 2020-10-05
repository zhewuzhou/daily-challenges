package zhewuzhou.me.tree

import zhewuzhou.utils.TreeNode

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
