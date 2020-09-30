package zhewuzhou.utils

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ListNode
        var lhs: ListNode? = this
        var rhs = other as ListNode?
        while (lhs != null && rhs != null) {
            if (lhs.`val` != rhs.`val`) {
                return false
            }
            lhs = lhs.next
            rhs = rhs.next
        }
        if (rhs != null || lhs != null) {
            return false
        }
        return true
    }

    override fun hashCode(): Int {
        var result = `val`
        result = 31 * result + (next?.hashCode() ?: 0)
        return result
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
