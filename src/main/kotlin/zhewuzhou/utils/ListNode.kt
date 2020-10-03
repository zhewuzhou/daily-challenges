package zhewuzhou.utils

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    fun listEquals(other: ListNode?): Boolean {
        var lhs: ListNode? = this
        var rhs = other
        while (lhs != null && rhs != null) {
            if (lhs.`val` != rhs.`val`) {
                return false
            }
            lhs = lhs.next
            rhs = rhs.next
        }
        if (lhs != null || rhs != null) {
            return false
        }
        return true
    }
}

fun List<Int>.toListNode(): ListNode? {
    if (this.isEmpty()) return null
    val nodes = this.map { ListNode(it) }
    for (i in 0 until nodes.lastIndex) {
        nodes[i].next = nodes[i + 1]
    }
    return nodes.first()
}
