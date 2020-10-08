package zhewuzhou.me.tree

import zhewuzhou.utils.TreeNode

fun minDepth(root: TreeNode?): Int {
    if (root == null) return 0
    return when {
        (root.left != null && root.right != null) -> Math.min(minDepth(root.left), minDepth(root.right)) + 1
        (root.left != null && root.right == null) -> minDepth(root.left) + 1
        (root.left == null && root.right != null) -> minDepth(root.right) + 1
        else -> 1
    }
}
