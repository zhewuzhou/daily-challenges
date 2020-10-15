package zhewuzhou.me.expr

class Fraction {
    val numerator: Int
    val denominator: Int

    constructor(numerator: Int, denominator: Int) {
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
        val lcm = lcm(this.denominator, rhs.denominator)
        val newNumerator = (lcm / this.denominator) * numerator + (lcm / rhs.denominator) * rhs.numerator
        return Fraction(newNumerator, lcm)
    }

    private fun normalize(numerator: Int, denominator: Int): Pair<Int, Int> {
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
    return ""
}
