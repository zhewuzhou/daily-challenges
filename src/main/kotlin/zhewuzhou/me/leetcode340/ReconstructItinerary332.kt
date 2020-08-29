package zhewuzhou.me.leetcode340

data class Ticket(var used: Boolean, val from: String, val to: String)

fun findItinerary(tickets: List<List<String>>): List<String> {
    if (tickets.isEmpty()) return listOf()
    val ts = tickets.map { Ticket(false, it[0], it[1]) }

    fun next(path: MutableList<String>): List<Ticket> =
        ts.filter { !it.used && it.from == path.last() }.sortedBy { it.to }

    fun doFind(path: MutableList<String>): List<String> {
        if (ts.all { it.used }) {
            return path
        }
        val nextSteps = next(path)
        for (n in nextSteps) {
            path.add(n.to)
            n.used = true
            val result = doFind(path)
            if (result.isNotEmpty()) return result
            path.remove(path.last())
            n.used = false
        }
        return listOf()
    }

    val result = mutableListOf<List<String>>()
    return doFind(mutableListOf("JFK"))
}
