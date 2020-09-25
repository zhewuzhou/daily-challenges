package zhewuzhou.me.dp

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
    val metrics = IntArray(s.length)
    for (i in 1 until s.length) {
        if (s[i] == ')' &&
            i - metrics[i - 1] - 1 >= 0 &&
            s[i - metrics[i - 1] - 1] == '(') {
            metrics[i] = metrics[i - 1] + 2
            metrics[i] += if (i - metrics[i - 1] - 2 >= 0) metrics[i - metrics[i - 1] - 2] else 0
            curMax = Math.max(metrics[i], curMax);
        }
    }
    return curMax;
}
