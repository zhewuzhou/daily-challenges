package zhewuzhou.me.datastructure

import java.util.*


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
    1
    nested.getList()!!.flatMap { convertNestedIntegerToList(it) }
}

/*
You can also using a stack to keep push iterator when there is nested integer until stack empty
 */
class NestedIterator1(nestedList: List<NestedInteger>) {
    private var cur = 0
    private val flattedList: List<Int> = nestedList.flatMap { convertNestedIntegerToList(it) }

    fun next(): Int {
        require(cur <= flattedList.lastIndex)
        return flattedList[cur++]
    }

    fun hasNext(): Boolean = cur < flattedList.lastIndex
}

class NestedIterator(nestedList: List<NestedInteger>) : Iterator<Int> {
    var stack = Stack<NestedInteger>()

    init {
        prepareStack(nestedList)
    }

    override fun next(): Int {
        require(stack.isNotEmpty())
        return stack.pop().getInteger()!!
    }

    override fun hasNext(): Boolean {
        while (stack.isNotEmpty() && !stack.peek().isInteger()) {
            val list = stack.pop().getList()!!
            prepareStack(list)
        }
        return !stack.isEmpty()
    }

    private fun prepareStack(nestedList: List<NestedInteger>) {
        for (i in nestedList.indices.reversed()) {
            stack.push(nestedList[i])
        }
    }
}
