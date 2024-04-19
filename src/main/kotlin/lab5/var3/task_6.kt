package lab5.var3

import java.io.File
import java.io.IOException

fun main(args: Array<String>) {
    if (args.size < 3) {
        println("Usage: <input file> <output file> <words to count separated by commas>")
        return
    }

    val inputFile = args[0]
    val outputFile = args[1]
    val wordsToCount = args[2].split(",").map { it.trim().toLowerCase() }.toSet()

    val wordCounts = mutableMapOf<String, Int>()

    try {
        File(inputFile).useLines { lines ->
            lines.forEach { line ->
                line.toLowerCase().split("\\s+".toRegex()).forEach { word ->
                    if (word in wordsToCount) {
                        wordCounts[word] = wordCounts.getOrDefault(word, 0) + 1
                    }
                }
            }
        }

        val sortedWords = wordCounts.toList().sortedBy { (_, value) -> value }.toMap()

        File(outputFile).printWriter().use { out ->
            sortedWords.forEach { (word, count) ->
                out.println("$word: $count")
            }
        }

        println("Word counts written to $outputFile")
    } catch (e: IOException) {
        println("Error reading from $inputFile or writing to $outputFile: ${e.message}")
    } catch (e: Exception) {
        println("An error occurred: ${e.message}")
    }
}
