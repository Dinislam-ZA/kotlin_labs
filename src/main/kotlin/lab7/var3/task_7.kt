package lab7.var3

fun encryptText(text: String): String {
    val result = StringBuilder()
    for (i in 0 until 3) {
        var index = i
        while (index < text.length) {
            result.append(text[index])
            index += 3
        }
    }
    return result.toString()
}

fun main() {
    val text = "Hello, this is an example text to be encrypted!"
    val encryptedText = encryptText(text)
    println(encryptedText)
}
