package lab9.var2

fun main(){
    val numbers = listOf<Int>(1, 2, 5, 4, 8, 10, 11, 22)
    val sum = numbers.filter { it.mod(2) == 0 }.sum()
    println("Сумма четных чисел равняется - $sum")
}