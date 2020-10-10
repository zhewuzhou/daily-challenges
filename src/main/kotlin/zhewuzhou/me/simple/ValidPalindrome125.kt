package zhewuzhou.me.simple

private fun isPalindrome(s: String): Boolean {
    if (s.isEmpty()) return true
    val ts = s.toCharArray()
        .filter { (it in 'a'..'z') || (it in 'A'..'Z') || (it in '0'..'9') }
        .map { it.toUpperCase() }
        .joinToString("")
    return ts.isEmpty() || ts == ts.reversed()
}
