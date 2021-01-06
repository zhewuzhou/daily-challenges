package zhewuzhou.me.daily

import java.util.*

/**
 * Sort Problem
 * [7,0],[4,4],[7,1],[6,1],[5,2] -> [5,0],[7,0],[5,2],[6,1],[4,4],[7,1]
 * How can I find the minimum?
 * 5,0 | 7,0 |
 * [6,0],[5,0],[4,0],[3,2],[2,2],[1,4] -> [4,0],[5,0],[2,2],[3,2],[1,4],[6,0]
 */


fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
    if (people.isEmpty() || people[0].isEmpty()) return arrayOf()
    val result = LinkedList<IntArray>()
    Arrays.sort(people) { a, b -> if (a[0] == b[0]) a[1].compareTo(b[1]) else b[0].compareTo(a[0]) }
    for (i in people.indices) {
        result.add(people[i][1], people[i])
    }
    return result.toTypedArray()
}