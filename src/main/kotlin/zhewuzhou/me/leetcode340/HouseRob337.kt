package zhewuzhou.me.leetcode340

import zhewuzhou.me.leetcode100.TreeNode


fun rob(root: TreeNode?): Int {
    if (root == null) return 0
    val robRoot = root.`val` +
        rob(root.left?.left) +
        rob(root.left?.right) +
        rob(root.right?.left) +
        rob(root.right?.right)
    val skipRoot = rob(root.left) + rob(root.left)
    return if (robRoot > skipRoot) robRoot else skipRoot
}
