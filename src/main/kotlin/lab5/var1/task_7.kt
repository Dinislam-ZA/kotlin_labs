package lab5.var1

import java.util.*

data class Fraction(val numerator: Int, val denominator: Int) {
    init {
        require(denominator != 0) { "Знаменатель не может быть равен 0" }
    }

    operator fun plus(other: Fraction): Fraction {
        val commonDenominator = this.denominator * other.denominator
        val newNumerator = this.numerator * other.denominator + other.numerator * this.denominator
        return Fraction(newNumerator, commonDenominator).simplify()
    }

    operator fun minus(other: Fraction): Fraction {
        val commonDenominator = this.denominator * other.denominator
        val newNumerator = this.numerator * other.denominator - other.numerator * this.denominator
        return Fraction(newNumerator, commonDenominator).simplify()
    }

    operator fun times(other: Fraction): Fraction {
        return Fraction(this.numerator * other.numerator, this.denominator * other.denominator).simplify()
    }

    operator fun div(other: Fraction): Fraction {
        if (other.numerator == 0) {
            throw ArithmeticException("Деление на дробь с нулевым числителем невозможно")
        }
        return Fraction(this.numerator * other.denominator, this.denominator * other.numerator).simplify()
    }

    private fun simplify(): Fraction {
        val gcd = gcd(this.numerator, this.denominator)
        return Fraction(this.numerator / gcd, this.denominator / gcd)
    }

    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }

    override fun toString(): String = "$numerator/$denominator"
}

fun modifyEvenIndexedFractions(fractions: Array<Fraction>) {
    for (i in fractions.indices step 2) {
        if (i + 1 < fractions.size) {
            fractions[i] = fractions[i] + fractions[i + 1]
        }
    }
}

fun main() {
    val scanner = java.util.Scanner(System.`in`)
    try {
        println("Введите количество дробей в массиве:")
        val k = scanner.nextInt()
        val fractions = Array(k) {
            println("Введите числитель и знаменатель для дроби ${it + 1}:")
            val numerator = scanner.nextInt()
            val denominator = scanner.nextInt()
            Fraction(numerator, denominator)
        }

        println("Исходный массив дробей: ${fractions.joinToString()}")
        modifyEvenIndexedFractions(fractions)
        println("Модифицированный массив дробей: ${fractions.joinToString()}")

        if (fractions.size > 1) {
            println("Сложение первых двух дробей модифицированного массива: ${fractions[0] + fractions[1]}")
            println("Вычитание первых двух дробей модифицированного массива: ${fractions[0] - fractions[1]}")
            println("Умножение первых двух дробей модифицированного массива: ${fractions[0] * fractions[1]}")
            println("Деление первых двух дробей модифицированного массива: ${fractions[0] / fractions[1]}")
        }
    } catch (e: ArithmeticException) {
        println("Ошибка при выполнении арифметической операции: ${e.message}")
    } catch (e: InputMismatchException) {
        println("Некорректный ввод. Пожалуйста, введите целые числа.")
    } catch (e: Exception) {
        println("Произошла ошибка: ${e.localizedMessage}")
    } finally {
        scanner.close()
    }
}
