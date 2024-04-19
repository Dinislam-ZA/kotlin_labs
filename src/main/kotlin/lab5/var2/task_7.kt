package lab5.var2

import java.util.InputMismatchException
import java.util.Scanner

data class Phone(
    var id: Int,
    var lastName: String,
    var firstName: String,
    var middleName: String,
    var address: String,
    var creditCardNumber: String,
    var debit: Double,
    var credit: Double,
    var cityCallTime: Int,
    var intercityCallTime: Int
) {
    override fun toString(): String = """
        Phone(id=$id, LastName='$lastName', FirstName='$firstName', MiddleName='$middleName',
              Address='$address', CreditCardNumber='$creditCardNumber', Debit=$debit,
              Credit=$credit, CityCallTime=$cityCallTime min, IntercityCallTime=$intercityCallTime min)
    """.trimIndent()
}

class Phones(private val phones: Array<Phone>) {
    fun listSubscribersWithHighCityCallTime(minCityCallTime: Int) {
        println("\nСведения об абонентах с временем внутригородских разговоров выше $minCityCallTime минут:")
        phones.filter { it.cityCallTime > minCityCallTime }
            .forEach { println(it) }
    }

    fun listSubscribersWithIntercityCalls() {
        println("\nСведения об абонентах, которые пользовались междугородной связью:")
        phones.filter { it.intercityCallTime > 0 }
            .forEach { println(it) }
    }

    fun listSubscribersAlphabetically() {
        println("\nСведения об абонентах в алфавитном порядке:")
        phones.sortedWith(compareBy { it.lastName + it.firstName + it.middleName })
            .forEach { println(it) }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val phonesArray = arrayOf(
        Phone(1, "Ivanov", "Ivan", "Ivanovich", "Some Address 1", "1111222233334444", 100.0, 50.0, 60, 30),
        Phone(2, "Petrov", "Petr", "Petrovich", "Some Address 2", "5555666677778888", 200.0, 40.0, 40, 50),
        Phone(3, "Sidorov", "Sidr", "Sidrovich", "Some Address 3", "2222333344445555", 300.0, 60.0, 30, 10),
        Phone(4, "Smirnov", "Smir", "Smirnovich", "Some Address 4", "6666777788889999", 400.0, 80.0, 20, 20),
        Phone(5, "Kuznetsov", "Kuzma", "Kuzmich", "Some Address 5", "7777888899990000", 500.0, 100.0, 70, 40)
    )

    val phones = Phones(phonesArray)

    try {
        println("Введите минимальное время внутригородских разговоров для фильтрации:")
        val minCityCallTime = readIntSafe(scanner)
        phones.listSubscribersWithHighCityCallTime(minCityCallTime)

        println("Абоненты, использовавшие междугородную связь:")
        phones.listSubscribersWithIntercityCalls()

        println("Абоненты в алфавитном порядке:")
        phones.listSubscribersAlphabetically()

    } catch (e: InputMismatchException) {
        println("Ошибка ввода. Убедитесь, что вводите корректные числовые значения.")
    } catch (e: Exception) {
        println("Произошла ошибка: ${e.localizedMessage}")
    } finally {
        scanner.close()
    }
}
