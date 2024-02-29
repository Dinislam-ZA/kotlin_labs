package lab2.var2


import kotlin.math.sqrt
import kotlin.random.Random

fun readN(caseNullNum: Int) = readlnOrNull()?.toIntOrNull() ?: caseNullNum

fun printMatrix(matrix: Array<Array<Int>>) = matrix.forEach { row ->
    println(row.joinToString(" ") { it.toString().padStart(3) })
}

fun rotateMatrix90(matrix: Array<Array<Int>>): Array<Array<Int>> {
    val n = matrix.size
    val rotated = Array(n) { Array(n) { 0 } }

    for (i in 0 until n) {
        for (j in 0 until n) {
            rotated[n - j - 1][i] = matrix[i][j]
        }
    }
    return rotated
}

fun rotateMatrix180(matrix: Array<Array<Int>>): Array<Array<Int>> = rotateMatrix90(rotateMatrix90(matrix))

fun rotateMatrix270(matrix: Array<Array<Int>>): Array<Array<Int>> = rotateMatrix90(rotateMatrix180(matrix))

fun frobeniusNorm(matrix: Array<Array<Int>>): Double {
    var sum = 0.0
    for (row in matrix) {
        for (element in row) {
            sum += element * element
        }
    }

    return sqrt(sum)
}

fun main() {
    println("Введите размерность матрицы n:")
    val n = readN(5)

    val matrix = Array(n) { Array(n) { 0 } }

    for (i in 0 until n) {
        for (j in 0 until n) {
            matrix[i][j] = Random.nextInt(-n, n + 1)
        }
    }

    println("Исходная матрица:")
    printMatrix(matrix)

    val matrixRotated90 = rotateMatrix90(matrix)
    println("Матрица, перевернутая на 90 градусов:")
    printMatrix(matrixRotated90)
    val matrixRotated180 = rotateMatrix180(matrix)
    println("Матрица, перевернутая на 180 градусов:")
    printMatrix(matrixRotated180)
    val matrixRotated270 = rotateMatrix270(matrix)
    println("Матрица, перевернутая на 270 градусов:")
    printMatrix(matrixRotated270)

    val normFrobenius = frobeniusNorm(matrix)
    println("\nНорма матрицы: $normFrobenius")
}


