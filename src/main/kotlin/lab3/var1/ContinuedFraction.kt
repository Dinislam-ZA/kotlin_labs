package lab3.var1

import common.IOHelper

class ContinuedFraction(private val coefficients: List<Double>, private var x: Double) {

    fun evaluate( n: Int): Double {
        var value = coefficients.getOrElse(n) { 0.0 }
        for (i in n - 1 downTo 0) {
            value = coefficients.getOrElse(i) { 0.0 } + x / value
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
        return this.evaluate(coefficients.size - 1) / other.evaluate(other.coefficients.size - 1)
    }
}


fun main(){
    println("Введите количество констант первой дроби")
    val n1 = IOHelper.readIntMy(4)
    println("Введите константы первой дроби")
    val coefficientsFirst = IOHelper.arrayFloatInput(n1)
    println("Введите количество констант второй дроби")
    val n2 = IOHelper.readIntMy(4)
    println("Введите константы второй дроби")
    val coefficientsSecond = IOHelper.arrayFloatInput(n2)

    val fractionFirst = ContinuedFraction(coefficientsFirst, 5.0)
    val fractionSecond = ContinuedFraction(coefficientsSecond, 5.0)

    println("Введите n")
    val n = IOHelper.readIntMy(3)
    println("Введите x")
    val x = IOHelper.readIntMy(3)
    println("Значение первой дроби при x = $x и n = $n - ${fractionFirst.evaluate(n)}")
    println("Значение второй дроби при x = $x и n = $n - ${fractionSecond.evaluate(n)}")

    println("Сложение дробей: ${fractionFirst + fractionSecond}")
    println("Вычитание дробей: ${fractionFirst + fractionSecond}")
    println("Умножение дробей: ${fractionFirst + fractionSecond}")
    println("Деление дробей: ${fractionFirst + fractionSecond}")
}