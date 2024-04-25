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
        outputDir.mkdirs()
    }

    val outputFile = File(outputDir, "formatted_code.txt")

    try {
        inputFile.bufferedReader().use { reader ->
            outputFile.printWriter().use { writer ->
                reader.forEachLine { line ->
                    writer.println(formatJavaCode(line))
                }
            }
        }
        println("Formatted code written to ${outputFile.absolutePath}")
    } catch (e: IOException) {
        println("Error reading from ${inputFile.path} or writing to ${outputFile.path}: ${e.message}")
    } catch (e: Exception) {
        println("An error occurred: ${e.message}")
    }
}

fun formatJavaCode(line: String): String {
    return line.replace("\\s+".toRegex(), " ")
        .replace("\\s*\\{\\s*".toRegex(), " { ")
        .replace("\\s*;\\s*".toRegex(), "; ")
        .trim()
}

