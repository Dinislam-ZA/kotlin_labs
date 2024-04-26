package lab7.var2

fun printWordsWithMinMaxLength(text: List<String>) {
    val words = mutableSetOf<String>()
    text.forEach { line ->
        line.split("\\s+".toRegex()).forEach { word ->
            words.add(word)
        }
    }

    val minLength = words.minOfOrNull { it.length }
    val maxLength = words.maxOfOrNull { it.length }

    val minWords = words.filter { it.length == minLength }.toSet()
    val maxWords = words.filter { it.length == maxLength }.toSet()

    println("Words with minimum length ($minLength): ${minWords.joinToString(", ")}")
    println("Words with maximum length ($maxLength): ${maxWords.joinToString(", ")}")
}

fun main() {
    val text = listOf(
        "elephant rides are really I fun",
        "cats and dogs ы",
        "hippopotamus",
        "fly hippopotamsa",
        "I"
    )
    printWordsWithMinMaxLength(text)
}
