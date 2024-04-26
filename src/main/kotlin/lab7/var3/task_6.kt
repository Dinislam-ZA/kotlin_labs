package lab7.var3

fun rotateWords(sentence: String): String {
    val words = sentence.split("\\s+".toRegex())
    if (words.size > 1) {
        val firstWord = words.first()
        return (words.drop(1) + firstWord).joinToString(" ")
    }
    return sentence
}

fun main() {
    val sentence = "Hello, this is an example sentence."
    val rotatedSentence = rotateWords(sentence)
    println(rotatedSentence)
}
