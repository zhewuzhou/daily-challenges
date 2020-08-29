package zhewuzhou.me.leetcode340

data class Ticket(var used: Boolean, val from: String, val to: String)


/* It is vital to remember that for any dfs solution:
    1. What is the different of
    path.removeAt(path.lastIndex)
    path.remove(n.to) or path.remove(path.last())
    because there might be duplication, so always do path.removeAt(path.lastIndex)
 */
fun findItinerary(tickets: List<List<String>>): List<String> {
    if (tickets.isEmpty()) return listOf()
    val ts = tickets.map { Ticket(false, it[0], it[1]) }

    fun next(cur: String): List<Ticket> =
        ts.filter { !it.used && it.from == cur }.sortedBy { it.to }

    fun doFind(path: MutableList<String>): List<String> {
        if (ts.all { it.used }) {
            return path
        }
        val nextSteps = next(path.last())
        for (n in nextSteps) {
            path.add(n.to)
            n.used = true
            val result = doFind(path)
            if (result.isNotEmpty()) return result
            path.removeAt(path.lastIndex)
            n.used = false
        }
        return listOf()
    }

    val result = mutableListOf<List<String>>()
    return doFind(mutableListOf("JFK"))
}
