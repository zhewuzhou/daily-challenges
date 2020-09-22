package zhewuzhou.me.string

fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) return ""
    var largest = strs[0]
    var smallest = strs[0]
    for (str in strs) {
        if (str < largest) largest = str
        if (str > smallest) smallest = str
    }
    var i = 0
    val len = Math.min(largest.length, smallest.length)
    while (i < len && largest[i] == smallest[i]) i++
    return largest.substring(0, i)
}

