package zhewuzhou.me.expr

import java.util.*

fun addOperators(num: String, target: Int): List<String> {
    /* A nice trick here variable forMul is used for the future next multiplication */
    fun backtrace(res: MutableList<String>, path: String, eval: Long, forMul: Long, index: Int) {
        if (index == num.length) {
            if (eval == target.toLong()) {
                res.add(path)
            }
        } else {
            for (i in index..num.lastIndex) {
                if (i != index && num[index] == '0') break /* prevent number with leading zero */
                val cur = num.substring(index, i + 1).toLong()
                if (index == 0) {
                    backtrace(res, path + cur, cur, cur, i + 1)
                } else {
                    backtrace(res, "$path+$cur", eval + cur, cur, i + 1)
                    backtrace(res, "$path-$cur", eval - cur, -cur, i + 1)
                    backtrace(res, "$path*$cur", eval - forMul + forMul * cur, forMul * cur, i + 1)
                }
            }
        }
    }

    val res: MutableList<String> = ArrayList()
    if (num.isEmpty()) return res
    backtrace(res, "", 0, 0, 0)
    return res
}
