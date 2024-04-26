package lab7.var4

fun printWordsInAlphabeticalOrder(text: String) {
    val words = text.split("[^\\p{L}\\p{Pd}\\p{Pc}]+".toRegex())
        .filter { it.isNotEmpty() }
        .sortedBy { it.lowercase() }

    println(words.joinToString(", "))
}

fun main() {
    val text = "Hello, this is an example! Words are collected and sorted."
    printWordsInAlphabeticalOrder(text)
}

