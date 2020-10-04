package zhewuzhou.me.backtracing

fun isInterleave(s1: String, s2: String, s3: String): Boolean {
    val caches = mutableMapOf<Pair<Int, Int>, Boolean>()
    fun backtrace(pos1: Int, pos2: Int): Boolean {
        if (pos1 == s1.length && pos2 == s2.length) {
            return true
        }
        val key = Pair(pos1, pos2)
        if (caches.containsKey(key)) return caches[key]!!
        val ti = pos1 + pos2
        var s1Move = false
        var s2Move = false
        if (pos1 <= s1.lastIndex && s3[ti] == s1[pos1]) {
            s1Move = backtrace(pos1 + 1, pos2)
        }
        if (pos2 <= s2.lastIndex && s3[ti] == s2[pos2]) {
            s2Move = backtrace(pos1, pos2 + 1)
        }
        caches[key] = s1Move || s2Move
        return caches[key]!!
    }
    if (s1.length + s2.length != s3.length) return false
    return backtrace(0, 0)
}
