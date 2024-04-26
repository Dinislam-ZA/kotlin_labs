package lab7.var2

fun printUniqueWordsWithSameFirstAndLastLetter(text: List<String>) {
    val uniqueWords = mutableSetOf<String>()
    text.forEach { line ->
        line.split("[^\\p{L}]+".toRegex())
            .filter { word -> word.length > 1 && word.first().equals(word.last(), ignoreCase = true) }
            .forEach { word -> uniqueWords.add(word.lowercase()) }
    }
    println(uniqueWords.joinToString(", "))
}

fun main() {
    val text = listOf(
        "Anna went to the cinema",
        "Bob saw a radar in the area",
        "Civic duties are important",
        "Deed is done"
    )
    printUniqueWordsWithSameFirstAndLastLetter(text)
}
