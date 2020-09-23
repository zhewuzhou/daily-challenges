package zhewuzhou.me.linkedlist

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    val length = listNodeLength(head)
    return when (length == n) {
        true -> {
            val nh = head?.next
            head?.next = null
            nh
        }
        false -> {
            var before = head
            var pc = 1
            while (pc < length - n) {
                pc += 1
                before = before?.next
            }
            val toRemove = before?.next
            before?.next = toRemove?.next
            head
        }
    }
}

private fun listNodeLength(head: ListNode?): Int {
    var nh = head
    var length = 1
    while (nh?.next != null) {
        nh = nh.next
        length += 1
    }
    return length
}
