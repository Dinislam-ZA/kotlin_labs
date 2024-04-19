package lab5.var1

import java.lang.Exception
import java.lang.IndexOutOfBoundsException
import java.util.InputMismatchException
import java.util.Scanner

class ContinuedFraction(private val coefficients: List<Double>, private var x: Double) {

    fun evaluate(n: Int): Double {
        if (n < 0 || n >= coefficients.size)
            throw IndexOutOfBoundsException("Index $n is out of bounds for list of size ${coefficients.size}")

        var value = coefficients.getOrElse(n) { throw IllegalArgumentException("Coefficient for index $n is not provided") }

        for (i in n - 1 downTo 0) {
            if (value == 0.0)
                throw ArithmeticException("Division by zero encountered during evaluation")
            value = coefficients.getOrElse(i) { throw IllegalArgumentException("Coefficient for index $i is not provided") } + x / value
        }

        return value
    }

    operator fun plus(other: ContinuedFraction): Double {
        return this.evaluate(coefficients.size - 1) + other.evaluate(other.coefficients.size - 1)
    }

    operator fun minus(other: ContinuedFraction): Double {
        return this.evaluate(coefficients.size - 1) - other.evaluate(other.coefficients.size - 1)
    }

    operator fun times(other: ContinuedFraction): Double {
        return this.evaluate(coefficients.size - 1) * other.evaluate(other.coefficients.size - 1)
    }

    operator fun div(other: ContinuedFraction): Double {
        val otherValue = other.evaluate(other.coefficients.size - 1)
        if (otherValue == 0.0)
            throw ArithmeticException("Attempt to divide by zero")
        return this.evaluate(coefficients.size - 1) / otherValue
    }
}

fun main() {
    val scanner = Scanner(System.`in`)

    try {
        println("Введите количество констант первой дроби")
        val n1 = scanner.nextInt()
        println("Введите константы первой дроби")
        val coefficientsFirst = List(n1) { scanner.nextDouble() }

        println("Введите количество констант второй дроби")
        val n2 = scanner.nextInt()
        println("Введите константы второй дроби")
        val coefficientsSecond = List(n2) { scanner.nextDouble() }

        val fractionFirst = ContinuedFraction(coefficientsFirst, 5.0)
        val fractionSecond = ContinuedFraction(coefficientsSecond, 5.0)

        println("Введите n")
        val n = scanner.nextInt()
        println("Введите x")
        val x = scanner.nextDouble()
        println("Значение первой дроби при x = $x и n = $n: ${fractionFirst.evaluate(n)}")
        println("Значение второй дроби при x = $x и n = $n: ${fractionSecond.evaluate(n)}")

        println("Сложение дробей: ${fractionFirst + fractionSecond}")
        println("Вычитание дробей: ${fractionFirst - fractionSecond}")
        println("Умножение дробей: ${fractionFirst * fractionSecond}")
        println("Деление дробей: ${fractionFirst / fractionSecond}")
    } catch (e: InputMismatchException) {
        println("Ошибка ввода. Пожалуйста, введите корректные данные.")
    } catch (e: IndexOutOfBoundsException) {
        println("Ошибка: ${e.message}")
    } catch (e: ArithmeticException) {
        println("Математическая ошибка: ${e.message}")
    } catch (e: Exception) {
        println("Произошла ошибка: ${e.localizedMessage}")
    } finally {
        scanner.close()
    }
}
