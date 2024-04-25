package lab6.var1
import java.io.File

fun sortFileLines(fileName: String): ArrayList<String> {
    val lines = File(fileName).readLines().toCollection(ArrayList())
    lines.sort()
    return lines
}

fun main() {
    val sortedLines = sortFileLines("D:\\kotlinBigData\\kotlin_labs\\src\\main\\kotlin\\lab6\\var1\\lab6.txt")
    println("Sorted lines:")
    sortedLines.forEach { println(it) }
}
