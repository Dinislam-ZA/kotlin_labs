package lab9.var1

import java.util.stream.Collectors
import java.util.stream.Stream

//fun main() {
//    val strings = listOf("Hello", "World", "Kotlin", "Java")
//    val result = strings.stream()
//        .collect(Collectors.joining(":"))
//    println(result)  // Вывод: Hello:World:Kotlin:Java
//}

// Думаю на котлине будет так правильней
fun main() {
    val strings = listOf("Hello", "World", "Kotlin", "Java")
    val result = strings.joinToString(":")
    println(result)  // Вывод: Hello:World:Kotlin:Java
}
