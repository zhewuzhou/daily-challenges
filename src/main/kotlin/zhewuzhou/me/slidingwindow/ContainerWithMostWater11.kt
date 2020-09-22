package zhewuzhou.me.slidingwindow


fun maxArea(heights: IntArray): Int {
    check(heights.size >= 2)
    var container = 0
    var left = 0
    var right = heights.size - 1
    while (left < right) {
        container = Math.max(container, (right - left) * Math.min(heights[left], heights[right]))
        when (heights[left].compareTo(heights[right])) {
            1 -> right -= 1
            -1 -> left += 1
            0 -> {
                right -= 1
                left += 1
            }
        }
    }
    return container
}
