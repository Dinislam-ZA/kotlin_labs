package lab5.var3

import java.io.File
import java.io.IOException

fun main(args: Array<String>) {
    if (args.size < 2) {
        println("Usage: <input file> <output file>")
        return
    }

    val inputFile = args[0]
    val outputFile = args[1]

    try {
        File(outputFile).printWriter().use { out ->
            File(inputFile).useLines { lines ->
                lines.forEach { line ->
                    out.println(line.split("\\s+".toRegex()).joinToString(" ") { word ->
                        word.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
                    })
                }
            }
        }

        println("Processed lines written to $outputFile")
    } catch (e: IOException) {
        println("Error reading from $inputFile or writing to $outputFile: ${e.message}")
    } catch (e: Exception) {
        println("An error occurred: ${e.message}")
    }
}
