package zhewuzhou.me.tree

import zhewuzhou.utils.Node

class PopulatingNextRightPointersEachNodeII117 {
    fun connect(root: Node?): Node? {
        var curRoot = root
        while (curRoot != null) {
            val dummyHead = Node(-1)
            var curr: Node? = dummyHead
            while (curRoot != null) {
                if (curRoot.left != null) {
                    curr?.next = curRoot.left
                    curr = curr?.next
                }
                if (curRoot.right != null) {
                    curr?.next = curRoot.right
                    curr = curr?.next
                }
                curRoot = curRoot.next
            }
            curRoot = dummyHead.next
        }
        return root
    }
}
