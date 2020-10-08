package zhewuzhou.me.tree

import zhewuzhou.utils.TreeNode

fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
    if (root == null) return false
    if (root.`val` == sum && root.left == null && root.right == null) return true
    return hasPathSum(root.left, sum - root.`val`)
        || hasPathSum(root.right, sum - root.`val`)
}
