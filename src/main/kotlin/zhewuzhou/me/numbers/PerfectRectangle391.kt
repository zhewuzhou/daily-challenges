package zhewuzhou.me.numbers

import java.util.*

data class Rectangle(val left: Int,
                     val bottom: Int,
                     val right: Int,
                     val up: Int) : Comparable<Rectangle> {
    override fun compareTo(other: Rectangle): Int {
        return when {
            this.up <= other.bottom -> -1
            this.bottom >= other.up -> 1
            else -> 0
        }
    }
}

data class LineSweeper(val xAxis: Int,
                       val isEnd: Boolean,
                       val rec: Rectangle) : Comparable<LineSweeper> {
    override fun compareTo(other: LineSweeper): Int {
        return when {
            this.xAxis != other.xAxis -> this.xAxis.compareTo(other.xAxis)
            else -> if (isEnd) -1 else 1
        }
    }
}


fun isRectangleCover(rectangles: Array<IntArray>): Boolean {
    if (rectangles.isEmpty() || rectangles[0].size != 4) return false
    val queue = PriorityQueue<LineSweeper>()
    var lowestBottom = rectangles[0][1]
    var highestUp = rectangles[0][1]
    val currentRecs = TreeSet<Rectangle>()
    for (r in rectangles) {
        lowestBottom = Math.min(lowestBottom, r[1])
        highestUp = Math.max(highestUp, r[3])
        val rec = Rectangle(r[0], r[1], r[2], r[3])
        queue.add(LineSweeper(r[0], false, rec))
        queue.add(LineSweeper(r[2], true, rec))
    }
    val fullHeight = highestUp - lowestBottom
    while (queue.isNotEmpty()) {
        val standard = queue.peek().xAxis
        while (queue.isNotEmpty() && queue.peek().xAxis == standard) {
            val l = queue.poll()
            if (l.isEnd) {
                currentRecs.remove(l.rec)
            } else {
                if (!currentRecs.add(l.rec)) {
                    return false
                }
            }
        }
        if (currentRecs.isNotEmpty()) {
            var lineUp = Int.MIN_VALUE
            var lineBottom = Int.MAX_VALUE
            var sumOfHeight = 0
            for (r in currentRecs) {
                lineUp = Math.max(r.up, lineUp)
                lineBottom = Math.min(r.bottom, lineBottom)
                sumOfHeight += r.up - r.bottom
            }
            if (lineUp != highestUp || lineBottom != lowestBottom || sumOfHeight != fullHeight) {
                return false
            }
        } else {
            if (queue.isNotEmpty()) {
                return false
            }
        }
    }
    return true
}
