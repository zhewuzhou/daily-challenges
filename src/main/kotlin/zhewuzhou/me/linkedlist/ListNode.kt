package zhewuzhou.me.linkedlist

class ListNode(var `val`: Int) {
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
