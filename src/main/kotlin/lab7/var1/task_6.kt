package lab7.var1

fun insertWordAfterSubstr(text: List<String>, substr: String, wordToInsert: String): List<String> {
    val regex = Regex("([\\w']+|[^\\w\\s]+)")

    return text.map { line ->
        val tokens = regex.findAll(line).toList()
        val result = mutableListOf<String>()

        tokens.forEachIndexed { _, matchResult ->
            val token = matchResult.value
            if ((token == ".") or (token == ",")){
                result[result.lastIndex] = result.last() + token
            }
            else
            {
                result.add(token)
                if (token.endsWith(substr)) {
                    result.add(wordToInsert)
                }
            }
        }

        result.joinToString(" ")
    }
}

fun main() {
    val text = listOf(
        "This is an example text where some words end with ing such as ending, baking, and nothing.",
        "Here is another line that needs processing."
    )
    val result = insertWordAfterSubstr(text, "ing", "inserted")
    result.forEach { println(it) }
}
