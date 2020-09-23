package zhewuzhou.me.linkedlist

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    val dummy: ListNode? = ListNode(1)
    dummy?.next = head
    var fast = head
    for (i in 1 until n) {
        fast = fast?.next
    }
    var slow = head
    var preSlow = dummy
    while (fast?.next != null) {
        fast = fast.next
        preSlow = slow
        slow = slow?.next
    }
    preSlow?.next = slow?.next
    return dummy?.next
}

