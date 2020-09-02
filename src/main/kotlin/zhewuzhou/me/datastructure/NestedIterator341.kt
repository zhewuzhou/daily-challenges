package zhewuzhou.me.datastructure

class NestedInteger {
    constructor()
    constructor(value: Int)
    fun isInteger(): Boolean = false
    fun getInteger(): Int? = 0
    fun setInteger(value: Int): Unit {}
    fun add(ni: NestedInteger): Unit {}
    fun getList(): List<NestedInteger>? = listOf()
}

fun convertNestedIntegerToList(nested: NestedInteger): List<Int> = if (nested.isInteger()) {
    listOf(nested.getInteger()!!)
} else {
    nested.getList()!!.flatMap { convertNestedIntegerToList(it) }
}

/*
You can also using a stack to keep push iterator when there is nested integer until stack empty
 */
class NestedIterator(nestedList: List<NestedInteger>) {
    private var cur = 0
    private val flattedList: List<Int> = nestedList.flatMap { convertNestedIntegerToList(it) }

    fun next(): Int {
        require(cur <= flattedList.lastIndex)
        return flattedList[cur++]
    }

    fun hasNext(): Boolean = cur < flattedList.lastIndex
}
