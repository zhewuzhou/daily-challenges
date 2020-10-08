package zhewuzhou.me.backtracing

import zhewuzhou.utils.TreeNode

fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
    fun backtrace(res: MutableList<List<Int>>, root: TreeNode?, comb: MutableList<TreeNode>, sum: Int) {
        if (root == null || sum < 0) return
        if (root.left == null && root.right == null && sum == 0) {
            val path = mutableListOf(*comb.toTypedArray())
            res.add(path.map { it.`val` })
        }
        for (t in listOf(root.left, root.right)) {
            if (t != null) {
                comb.add(t)
                backtrace(res, t, comb, sum - t.`val`)
                comb.removeAt(comb.lastIndex)
            }
        }
    }
    if (root == null) return listOf()
    val res = mutableListOf<List<Int>>()
    backtrace(res, root, mutableListOf(root), sum - root.`val`)
    return res
}
