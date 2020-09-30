package zhewuzhou.me.slidingwindow

import java.util.*


fun minWindow(s: String, t: String): String {
    val countMap = IntArray(128)
    for (c in t.toCharArray()) {
        countMap[c.toInt()]++
    }
    var left = 0
    var right = 0
    var minLeft = 0
    var minLen = Int.MAX_VALUE
    var counter = t.length
    while (right < s.length) {
        val c1 = s[right]
        if (countMap[c1.toInt()] > 0) counter--
        countMap[c1.toInt()]--
        right++
        while (counter == 0) {
            if (minLen > right - left) {
                minLen = right - left
                minLeft = left
            }
            val c2 = s[left]
            countMap[c2.toInt()]++
            if (countMap[c2.toInt()] > 0) counter++
            left++
        }
    }
    return if (minLen == Int.MAX_VALUE) "" else s.substring(minLeft, minLeft + minLen)
}

/**
 * This is very slow version of implementation
 */

fun minWindowDFS(src: String, t: String): String {
    if (t.length > src.length) return ""
    val target = t.associate { key -> Pair(key, t.count { it == key }) }.toMap()
    val count = mutableMapOf<Char, Int>()
    val queue = LinkedList<Char>()
    var res = "$src "
    for (i in src.indices) {
        if (count.isNotEmpty() || (count.isEmpty() && t.contains(src[i]))) {
            queue.add(src[i])
        }
        if (t.contains(src[i])) {
            count[src[i]] = (count[src[i]] ?: 0) + 1
            if (target.all { (count[it.key] ?: 0) >= it.value }) {
                res = if (res.length > queue.size) queue.joinToString("") else res
                val first = queue.pop()!!
                count[first] = (count[first]!! - 1)
                while ((queue.isNotEmpty()) &&
                    (!t.contains(queue.peek()) ||
                        (t.contains(queue.peek()) && count[queue.peek()]!! > target[queue.peek()]!!) ||
                        (target.all { (count[it.key] ?: 0) >= it.value } && queue.size >= res.length))) {
                    if (t.contains(queue.peek())) {
                        count[queue.peek()] = count[queue.peek()]!! - 1
                    }
                    queue.pop()
                }
                if (target.all { (count[it.key] ?: 0) >= it.value } && queue.size < res.length) {
                    res = queue.joinToString("")
                }
            }
        }
    }
    return if (res.length > src.length) "" else res
}
