package zhewuzhou.me.expr

import java.util.*

class Fraction(numerator: Int, denominator: Int) {
    val numerator: Int
    val denominator: Int

    init {
        val normal = normalize(numerator, denominator)
        this.numerator = normal.first
        this.denominator = normal.second
    }

    override fun toString(): String {
        return "$numerator/$denominator"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Fraction

        if (numerator != other.numerator) return false
        if (denominator != other.denominator) return false

        return true
    }

    override fun hashCode(): Int {
        var result = numerator
        result = 31 * result + denominator
        return result
    }

    operator fun plus(rhs: Fraction): Fraction {
        return fractionOp(rhs, Int::plus)
    }

    operator fun minus(rhs: Fraction): Fraction {
        return fractionOp(rhs, Int::minus)
    }

    private fun fractionOp(rhs: Fraction, op: (Int, Int) -> Int): Fraction {
        val lcm = lcm(this.denominator, rhs.denominator)
        val newNumerator = op(
            (lcm / this.denominator) * numerator,
            (lcm / rhs.denominator) * rhs.numerator
        )
        return Fraction(newNumerator, lcm)
    }

    private fun normalize(numerator: Int, denominator: Int): Pair<Int, Int> {
        if (numerator == 0) return Pair(0, 1)
        val gcd = gcd(numerator, denominator)
        val factor = if (denominator < 0) -1 else 1
        return Pair((numerator / gcd) * factor,
            (denominator / gcd) * factor)
    }

    private fun gcd(a: Int, b: Int): Int {
        val lhs = Math.abs(a)
        val rhs = Math.abs(b)
        return if (rhs == 0) lhs else gcd(rhs, lhs % rhs)
    }

    private fun lcm(a: Int, b: Int): Int {
        val lhs = Math.abs(a)
        val rhs = Math.abs(b)
        return lhs * (rhs / gcd(lhs, rhs))
    }
}

fun fractionAddition(expression: String): String {
    if (!expression.contains('/')) return Fraction(expression.toInt(), 1).toString()
    var res: Fraction? = null
    var curFraction: Fraction? = null
    var numerator = 0
    var denominator = 1
    var cur = 1
    val num = mutableListOf(expression[0])
    while (cur <= expression.length) {
        if (cur == expression.length) {
            denominator = num.joinToString("").toInt()
            curFraction = Fraction(numerator, denominator)
        } else {
            when (expression[cur]) {
                '/' -> {
                    numerator = num.joinToString("").toInt()
                    num.clear()
                }
                in '0'..'9' -> num.add(expression[cur])
                else -> {
                    denominator = num.joinToString("").toInt()
                    curFraction = Fraction(numerator, denominator)
                    num.clear()
                    num.add(expression[cur])
                }
            }
        }
        res = acc(curFraction, res)
        curFraction = null
        cur += 1
    }
    return res.toString()
}

fun fractionAdditionFast(expression: String): String {
    if (!expression.contains('/')) return Fraction(expression.toInt(), 1).toString()
    val sc = Scanner(expression).useDelimiter("/|(?=[-+])")
    var res: Fraction? = null
    var numerator = 0
    var denominator = 1
    while (sc.hasNext()) {
        numerator = sc.nextInt()
        denominator = sc.nextInt()
        res = acc(Fraction(numerator, denominator), res)
    }
    return res.toString()
}

private fun acc(acc: Fraction?, res: Fraction?): Fraction? {
    if (acc == null) return res
    if (res == null) return acc
    return res + acc
}
