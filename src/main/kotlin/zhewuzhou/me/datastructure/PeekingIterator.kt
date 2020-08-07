package zhewuzhou.me.datastructure


class PeekingIterator(var iter: Iterator<Int>) : Iterator<Int> {
    var next: Int = 0
    var noSuchElement = false

    init {
        advanceIter()
    }

    fun peek(): Int {
        return next
    }

    override fun next(): Int {
        if (noSuchElement) throw NoSuchElementException()
        val res = next
        advanceIter()
        return res
    }

    override fun hasNext(): Boolean {
        return !noSuchElement
    }

    private fun advanceIter() {
        if (iter.hasNext()) {
            next = iter.next()
        } else {
            noSuchElement = true
        }
    }
}
