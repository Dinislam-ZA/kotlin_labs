package lab5.var4

import java.io.File
import java.io.IOException

fun main(args: Array<String>) {
    if (args.size < 2) {
        println("Usage: <input file> <output directory>")
        return
    }

    val inputFile = File(args[0])
    val outputDir = File(args[1])

    if (!outputDir.exists()) {
        outputDir.mkdirs()  // Создаем директорию, если она не существует
    }

    val outputFile = File(outputDir, "filtered_text.txt")

    try {
        inputFile.bufferedReader().use { reader ->
            outputFile.printWriter().use { writer ->
                reader.forEachLine { line ->
                    writer.println(removeWords(line))
                }
            }
        }
        println("Processed text written to ${outputFile.absolutePath}")
    } catch (e: IOException) {
        println("Error handling file: ${e.message}")
    } catch (e: Exception) {
        println("An error occurred: ${e.message}")
    }
}

fun removeWords(line: String): String {
    val words = line.split("\\s+".toRegex())
    val toRemove = words.filter { it.length in 3..5 }
    val maxEvenCount = toRemove.size - toRemove.size % 2  // Находим максимальное четное количество

    var newWords = mutableListOf<String>()
    var removedCount = 0

    for (word in words) {
        if (word.length in 3..5 && removedCount < maxEvenCount) {
            removedCount++
        } else {
            newWords.add(word)
        }
    }

    return newWords.joinToString(" ")
}
