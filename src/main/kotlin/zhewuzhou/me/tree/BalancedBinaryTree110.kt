package zhewuzhou.me.tree

import zhewuzhou.utils.TreeNode

fun isBalanced(root: TreeNode?): Boolean {
    if (root == null) return true
    if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) return false
    return isBalanced(root.left) && isBalanced(root.right)
}

private fun getDepth(root: TreeNode?): Int {
    if (root == null) return 0
    return when {
        (root.left != null && root.right != null) -> Math.max(getDepth(root.left), getDepth(root.right)) + 1
        (root.left != null && root.right == null) -> getDepth(root.left) + 1
        (root.left == null && root.right != null) -> getDepth(root.right) + 1
        else -> 1
    }
}
