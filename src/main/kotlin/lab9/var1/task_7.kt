package lab9.var1

import java.util.stream.Collectors

//fun main() {
//    val strings = listOf("apple", "banana", "apple", "orange", "banana", "grape")
//    val uniqueStrings = strings.stream()
//        .distinct()
//        .collect(Collectors.toList())
//
//    println(uniqueStrings) // Вывод: [apple, banana, orange, grape]
//}


fun main() {
    val strings = listOf("apple", "banana", "apple", "orange", "banana", "grape")
    val uniqueStringsArray = strings.distinct().toTypedArray()
    println(uniqueStringsArray.joinToString(", "))  // Вывод: apple, banana, orange, grape
}



