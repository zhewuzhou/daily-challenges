package zhewuzhou.me.linkedlist

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    /*Pattern1: dummy act as the anchor given list node could be challenged*/
    val dummy: ListNode? = ListNode(1)
    dummy?.next = head

    /*Pattern2: fast/slow pointer to locate specific pos*/
    var fast = head
    var slow = head
    var preSlow = dummy

    /*Pattern3: should run it in brain for small list*/
    for (i in 1 until n) {
        fast = fast?.next
    }
    while (fast?.next != null) {
        fast = fast.next
        preSlow = slow
        slow = slow?.next
    }
    preSlow?.next = slow?.next
    return dummy?.next
}

