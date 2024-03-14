package lab3.var1

data class Fraction(val numerator: Int, val denominator: Int) {
    init {
        require(denominator != 0) { "Знаменатель не может быть равен 0" }
    }

    operator fun plus(other: Fraction): Fraction {
        if (this.denominator == other.denominator) {
            return Fraction(this.numerator + other.numerator, this.denominator).simplify()
        } else {
            val commonDenominator = this.denominator * other.denominator
            val newNumerator = this.numerator * other.denominator + other.numerator * this.denominator
            return Fraction(newNumerator, commonDenominator).simplify()
        }
    }

    operator fun minus(other: Fraction): Fraction {
        if (this.denominator == other.denominator) {
            return Fraction(this.numerator - other.numerator, this.denominator).simplify()
        } else {
            val commonDenominator = this.denominator * other.denominator
            val newNumerator = this.numerator * other.denominator - other.numerator * this.denominator
            return Fraction(newNumerator, commonDenominator).simplify()
        }
    }

    operator fun times(other: Fraction): Fraction {
        return Fraction(this.numerator * other.numerator, this.denominator * other.denominator).simplify()
    }

    operator fun div(other: Fraction): Fraction {
        return Fraction(this.numerator * other.denominator, this.denominator * other.numerator).simplify()
    }

    fun simplify(): Fraction {
        val gcd = gcd(this.numerator, this.denominator)
        return Fraction(this.numerator / gcd, this.denominator / gcd)
    }

    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }

    override fun toString(): String = "$numerator/$denominator"
}

// Функция для изменения каждой дроби с четным индексом
fun modifyEvenIndexedFractions(fractions: Array<Fraction>) {
    for (i in fractions.indices step 2) {
        if (i + 1 < fractions.size) {
            fractions[i] = fractions[i] + fractions[i + 1]
        }
    }
}

fun main() {
    val fractions = arrayOf(Fraction(1, 2), Fraction(2, 3), Fraction(3, 4), Fraction(4, 5))
    println("Исходный массив дробей: ${fractions.contentToString()}")

    modifyEvenIndexedFractions(fractions)
    println("Модифицированный массив дробей: ${fractions.contentToString()}")

    println("Сложение первых двух дробей модифицированного массива: ${fractions[0] + fractions[1]}")
    println("Вычитания первых двух дробей модифицированного массива: ${fractions[0] - fractions[1]}")
    println("Умножение первых двух дробей модифицированного массива: ${fractions[0] * fractions[1]}")
    println("Деление первых двух дробей модифицированного массива: ${fractions[0] / fractions[1]}")
}
