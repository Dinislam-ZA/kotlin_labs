package lab1.var2

//Здесь представлен код для пунктов 6 и 7 из второго варианта первой лабораторной работы

fun readN(caseNullNum: Int) = readlnOrNull()?.toIntOrNull() ?: caseNullNum

fun gcd(a: Int, b: Int): Int {
    if (b == 0) return a
    return gcd(b, a % b)
}

fun lcm(a: Int, b: Int): Int = a / gcd(a, b) * b

fun gcdOfArray(arr: Array<Int>): Int {
    var result = arr[0]
    for (i in 1 until arr.size) {
        result = gcd(result, arr[i])
    }
    return result
}

fun lcmOfArray(arr: Array<Int>): Int {
    var result = arr[0]
    for (i in 1 until arr.size) {
        result = lcm(result, arr[i])
    }
    return result
}

fun main(){
    var array: Array<Int> = arrayOf()
    println("Введите размер массива")
    val n = readN(10)
    for(i in 1..n){
        println("Введите элемент массива под номером $i")
        val num = readN(666)
        array += num
    }
    println("Список трехзначных элементов массива")
    array.filter { num -> num in 100..999}.map { println(it) }

    println("Наибольший общий делитель - ${gcdOfArray(array)}")
    println("Наименьшее общее кратное - ${lcmOfArray(array)}")
}