package zhewuzhou.me.numberssort

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
    var leftMost = Int.MAX_VALUE
    var rightMost = Int.MIN_VALUE
    var upMost = Int.MIN_VALUE
    var bottomMost = Int.MAX_VALUE
    var areaSum = 0L
    val pointsCount = mutableMapOf<Pair<Int, Int>, Int>()
    for (r in rectangles) {
        leftMost = Math.min(leftMost, r[0])
        rightMost = Math.max(rightMost, r[2])
        bottomMost = Math.min(bottomMost, r[1])
        upMost = Math.max(upMost, r[3])
        areaSum += (r[3] - r[1]) * (r[2] - r[0])
        addCount(pointsCount, Pair(r[0], r[1]))
        addCount(pointsCount, Pair(r[0], r[3]))
        addCount(pointsCount, Pair(r[2], r[1]))
        addCount(pointsCount, Pair(r[2], r[3]))
    }
    if (areaSum != (rightMost - leftMost).toLong() * (upMost - bottomMost).toLong()) {
        return false
    }
    if (notCountOne(pointsCount, Pair(leftMost, bottomMost)) ||
        notCountOne(pointsCount, Pair(rightMost, upMost)) ||
        notCountOne(pointsCount, Pair(leftMost, upMost)) ||
        notCountOne(pointsCount, Pair(rightMost, bottomMost))) {
        return false
    }
    for (key in pointsCount.keys) {
        if (key.first in (leftMost + 1) until rightMost ||
            key.second in (bottomMost + 1) until upMost) {
            if (pointsCount[key]!! != 2 && pointsCount[key]!! != 4) {
                return false
            }
        }
    }
    return true
}

private fun notCountOne(pointsCount: MutableMap<Pair<Int, Int>, Int>, key: Pair<Int, Int>): Boolean {
    if (!pointsCount.containsKey(key) || pointsCount[key]!! != 1) {
        return true
    }
    return false
}

private fun addCount(pointsCount: MutableMap<Pair<Int, Int>, Int>, leftBottom: Pair<Int, Int>) {
    if (pointsCount.containsKey(leftBottom)) {
        pointsCount[leftBottom] = pointsCount[leftBottom]!! + 1
    } else {
        pointsCount[leftBottom] = 1
    }
}

fun isRectangleCoverSweep(rectangles: Array<IntArray>): Boolean {
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
