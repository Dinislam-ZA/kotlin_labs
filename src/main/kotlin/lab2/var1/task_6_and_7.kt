package lab2.var1

import java.text.SimpleDateFormat
import java.util.*

// Не знаю, зачем я так заморочился с вводом.....

fun readN(caseNullNum: Int) = readlnOrNull()?.toIntOrNull() ?: caseNullNum

fun isAllCharactersUnique(word: String): Boolean {
    return word.length == word.toSet().size
}

fun main(){
    println("Введите количество слов")
    val n = readN(10)
    var inputCnt = 0
    var resultForSortedChars:String? = null
    var resultForDifferentChars:String? = null
    println("Введите слова")
    while (inputCnt < n){
        val s = readlnOrNull() ?: "word"
        val inputedWords = s.split(" ")
        val words = if (inputedWords.size > n - inputCnt) inputedWords.take(n - inputCnt) else inputedWords
        inputCnt += words.size
        for(word in words){
            var flagForSortedChars= true
            var flagForDifferentChars = true
            for (j in 0 until word.length - 1){
                if (word[j] >= word[j+1]) flagForSortedChars= false
                if (!isAllCharactersUnique(word)) flagForDifferentChars = false // Можно было бы наверное какой-нибудь filter().first() использовать, но да ладно
            }
            if (flagForSortedChars && (resultForSortedChars == null)){
                resultForSortedChars = word
            }
            if (flagForDifferentChars && (resultForDifferentChars == null)){
                resultForDifferentChars = word
            }
        }
    }
    if (resultForSortedChars != null) println("Слово, в котором символы отсортированы по кодам - $resultForSortedChars") else println("Нет слов, в которых коды символов отсортированы по возрастанию")
    if (resultForDifferentChars != null) println("Слово, в котором символы не повторяются - $resultForDifferentChars") else println("Нет слов, в которых символы не повторяются")

    val name = "Zalimkhanov Dinislam Alievich"
    val currentDate = Date()
    val dateFormat = SimpleDateFormat("dd.MM.yyyy HH:mm:ss")
    val submitDate = dateFormat.format(currentDate)
    println("$name submit lab on $submitDate")
}