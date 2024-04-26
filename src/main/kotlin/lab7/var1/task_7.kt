package lab7.var1

fun modifyTextBasedOnFlag(text: List<String>, charToModify: Char, flag: Int, k: Int = 0): List<String> {
    return if (flag == 0) {
        text.map { it.replace(charToModify.toString(), "") }
    } else {
        text.map { line ->
            if (line.length > k) line.substring(0, k) + charToModify + line.substring(k)
            else line + charToModify
        }
    }
}

fun main() {
    val text = listOf(
        "Example text for deletion.",
        "Another line with more characters."
    )
    println("Removing 'e':")
    modifyTextBasedOnFlag(text, 'e', 0).forEach { println(it) }

    println("\nInserting 'Z' after 5th character:")
    modifyTextBasedOnFlag(text, 'Z', 1, 5).forEach { println(it) }
}
