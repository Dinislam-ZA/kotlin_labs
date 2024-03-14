package lab3.var2

import common.IOHelper

class Phone(
    private var id: Int,
    private var lastName: String,
    private var firstName: String,
    private var middleName: String,
    private var address: String,
    private var creditCardNumber: String,
    private var debit: Double,
    private var credit: Double,
    private var cityCallTime: Int,
    private var intercityCallTime: Int
) {

    fun getId() = id
    fun setId(value: Int) {
        id = value
    }

    fun getLastName() = lastName
    fun setLastName(value: String) {
        lastName = value
    }

    fun getFirstName() = firstName
    fun setFirstName(value: String) {
        firstName = value
    }

    fun getMiddleName() = middleName
    fun setMiddleName(value: String) {
        middleName = value
    }

    fun getAddress() = address
    fun setAddress(value: String) {
        address = value
    }

    fun getCreditCardNumber() = creditCardNumber
    fun setCreditCardNumber(value: String) {
        creditCardNumber = value
    }

    fun getDebit() = debit
    fun setDebit(value: Double) {
        debit = value
    }

    fun getCredit() = credit
    fun setCredit(value: Double) {
        credit = value
    }

    fun getCityCallTime() = cityCallTime
    fun setCityCallTime(value: Int) {
        cityCallTime = value
    }

    fun getIntercityCallTime() = intercityCallTime
    fun setIntercityCallTime(value: Int) {
        intercityCallTime = value
    }


    override fun toString(): String {
        return "Phone(id=$id, lastName='$lastName', firstName='$firstName', middleName='$middleName', " +
                "address='$address', creditCardNumber='$creditCardNumber', debit=$debit, " +
                "credit=$credit, cityCallTime=$cityCallTime, intercityCallTime=$intercityCallTime)"
    }
}

class Phones(val phones: Array<Phone>) {
    fun listSubscribersWithHighCityCallTime(minCityCallTime: Int) {
        println("Сведения об абонентах с временем внутригородских разговоров выше заданного")
        phones.filter { it.getCityCallTime() > minCityCallTime }
            .forEach { println(it) }
    }

    fun listSubscribersWithIntercityCalls() {
        println("Сведения об абонентах, которые пользовались междугородной связью")
        phones.filter { it.getIntercityCallTime() > 0 }
            .forEach { println(it) }
    }

    fun listSubscribersAlphabetically() {
        println("Сведения об абонентах в алфавитном порядке")
        phones.sortedWith(compareBy { it.getLastName() + it.getFirstName() + it.getMiddleName() })
            .forEach { println(it) }
    }
}

fun main() {
    val phonesArray = arrayOf(
        Phone(1, "Ivanov", "Ivan", "Ivanovich", "Some Address 1", "1111222233334444", 100.0, 50.0, 60, 30),
        Phone(2, "Petrov", "Petr", "Petrovich", "Some Address 2", "5555666677778888", 200.0, 40.0, 40, 50),
        Phone(3, "Sidorov", "Sidr", "Sidrovich", "Some Address 3", "2222333344445555", 300.0, 60.0, 30, 10),
        Phone(4, "Smirnov", "Smir", "Smirnovich", "Some Address 4", "6666777788889999", 400.0, 80.0, 20, 20),
        Phone(5, "Kuznetsov", "Kuzma", "Kuzmich", "Some Address 5", "7777888899990000", 500.0, 100.0, 70, 40)
    )


    val phones = Phones(phonesArray)

    println("Введите минимальное время внутригородских разговоров для фильтрации")
    val minCityCallTime = IOHelper.readIntMy(40)
    phones.listSubscribersWithHighCityCallTime(minCityCallTime)

    println("Абоненты, использовавшие междугородную связь:")
    phones.listSubscribersWithIntercityCalls()

    println("Абоненты в алфавитном порядке:")
    phones.listSubscribersAlphabetically()
}