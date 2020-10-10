package zhewuzhou.utils

object Graph {
    data class Node(val `val`: Int) {
        var neighbors: ArrayList<Node?> = ArrayList()
    }
}
