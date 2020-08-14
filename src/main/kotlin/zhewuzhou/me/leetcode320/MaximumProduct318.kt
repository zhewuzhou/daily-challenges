package zhewuzhou.me.leetcode320
/*
If we N*N solution is simple but slow
If Mapping all the char to pos:
a -> [0, 1], it's seems not very useful
How do you know if 2 words share any common char?
Given a word, we want to see that the other word only contains 26-word
 */

fun maxProduct(words: Array<String>): Int {
    if (words.isEmpty()) return 0
    val value = hash(words)
    var maxProduct = 0
    for (i in words.indices) {
        for (j in (i + 1)..words.lastIndex) {
            if (value[i].and(value[j]) == 0) {
                maxProduct = Math.max(maxProduct, words[i].length * words[j].length)
            }
        }
    }
    return maxProduct
}

private fun hash(words: Array<String>): IntArray {
    val value = IntArray(words.size)
    for (i in words.indices) {
        val w = words[i]
        value[i] = 0
        for (c in w) {
            value[i] = value[i].or(1.shl(c - 'a'))
        }
    }
    return value
}
