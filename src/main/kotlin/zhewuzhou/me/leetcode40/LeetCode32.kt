package zhewuzhou.me.leetcode40

/*
    TODO: 1. Stack spam
    TODO: 2. Dynamic programmings comes from the examples
    TODO: 3. Play with more examples
    TODO: 4. Summary of how to write better program
    TODO: 5. Stop when feel not right
 */
fun longestValidParentheses(s: String): Int {
    if (s.length <= 1) return 0;
    var curMax = 0;
    val longest = IntArray(s.length)
    for (i in 1 until s.length) {
        if (s[i] == ')' &&
            i - longest[i - 1] - 1 >= 0 &&
            s[i - longest[i - 1] - 1] == '(') {
            longest[i] = longest[i - 1] + 2
            longest[i] += if (i - longest[i - 1] - 2 >= 0) longest[i - longest[i - 1] - 2] else 0
            curMax = Math.max(longest[i], curMax);
        }
    }
    return curMax;
}
