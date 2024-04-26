package lab7.var4

fun countWordsStartingWithCapitalLetter(text: String): Int {
    val words = text.split("\\s+".toRegex())
        .map { it.replace("[^\\p{L}\\p{Pd}\\p{Pc}']".toRegex(), "") }
        .filter { it.isNotEmpty() && it[0].isUpperCase() }

    return words.size
}

fun main() {
    val text = "Sometimes you will see Text that includes Capitalized words like New York or McDonald's."
    val count = countWordsStartingWithCapitalLetter(text)
    println("Number of words starting with a capital letter: $count")
}

