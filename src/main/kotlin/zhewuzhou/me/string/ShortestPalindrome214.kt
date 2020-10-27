package zhewuzhou.me.string

import zhewuzhou.me.datastructure.KMPMatcher

fun shortestPalindrome(txt: String): String {
    val tl = txt.length
    if (txt.isEmpty() || tl == 1) return txt
    val reversed = txt.reversed()
    val r = KMPMatcher(txt).search(reversed)
    return if (r.first < tl) txt else reversed.substring(0, tl - r.second) + txt
}


