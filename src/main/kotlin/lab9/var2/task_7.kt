package lab9.var2

fun main(){
    val numbers = listOf<Int>(21, 12, 5, 24, 82, 10, 11, 22)
    val average = numbers.map { it - 10 }.average()
    println("Среднее равняется - $average")
}