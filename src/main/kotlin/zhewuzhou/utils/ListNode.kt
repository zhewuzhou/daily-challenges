package zhewuzhou.utils

class ListNode(var `val`: Int) {
    companion object {
        fun listEqual(lhs: ListNode?, rhs: ListNode?): Boolean {
            var l = lhs
            var r = rhs
            while (l != null && r != null) {
                if (l.`val` != r.`val`) {
                    return false
                }
                l = l.next
                r = r.next
            }
            if (l != null || r != null) {
                return false
            }
            return true
        }
    }

    var next: ListNode? = null
}

fun List<Int>.toListNode(): ListNode? {
    if (this.isEmpty()) return null
    val nodes = this.map { ListNode(it) }
    for (i in 0 until nodes.lastIndex) {
        nodes[i].next = nodes[i + 1]
    }
    return nodes.first()
}
