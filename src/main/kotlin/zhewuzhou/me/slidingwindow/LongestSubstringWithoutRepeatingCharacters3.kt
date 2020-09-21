package zhewuzhou.me.slidingwindow

fun lengthOfLongestSubstring(s: String): Int {
    var maxLen = 0
    val window = mutableSetOf<Char>()
    var left = 0
    var right = 0
    while (right < s.length) {
        while (window.contains(s[right])) {
            window.remove(s[left++])
        }
        window.add(s[right++])
        maxLen = Math.max(maxLen, right - left)
    }
    return maxLen
}
