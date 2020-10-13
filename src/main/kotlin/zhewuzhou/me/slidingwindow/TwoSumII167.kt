package zhewuzhou.me.leetcode180

fun twoSum(numbers: IntArray, target: Int): IntArray {
    var start = 0
    var end = numbers.size - 1
    while (numbers[start] + numbers[end] != target) {
        when {
            numbers[start] + numbers[end] > target -> end -= 1
            else -> start += 1
        }
    }
    return intArrayOf(start + 1, end + 1)
}
