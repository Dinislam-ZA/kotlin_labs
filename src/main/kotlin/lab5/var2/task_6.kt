package lab5.var2

import java.util.InputMismatchException
import java.util.Scanner

data class House(
    var id: Int,
    var apartmentNumber: Int,
    var area: Double,
    var floor: Int,
    var numberOfRooms: Int,
    var street: String,
    var buildingType: String,
    var operationTerm: Int
) {
    override fun toString(): String {
        return "House(id=$id, apartmentNumber=$apartmentNumber, area=$area, floor=$floor, " +
                "numberOfRooms=$numberOfRooms, street='$street', buildingType='$buildingType', " +
                "operationTerm=$operationTerm)"
    }
}

class Houses(val houses: Array<House>) {
    fun listApartmentsWithRooms(rooms: Int) {
        println("Список квартир с заданным числом комнат:")
        houses.filter { it.numberOfRooms == rooms }
            .forEach { println(it) }
    }

    fun listApartmentsWithRoomsAndFloor(rooms: Int, floorRange: IntRange) {
        println("Список квартир с заданным числом комнат и этажом в промежутке $floorRange:")
        houses.filter { it.numberOfRooms == rooms && it.floor in floorRange }
            .forEach { println(it) }
    }

    fun listApartmentsWithAreaGreaterThan(area: Double) {
        println("Список квартир с площадью превышающей $area:")
        houses.filter { it.area > area }
            .forEach { println(it) }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    try {
        val houses = Houses(arrayOf(
            House(1, 12, 55.0, 3, 2, "Green Street", "Apartment", 5),
            House(2, 45, 68.0, 6, 3, "Sunset Boulevard", "Townhouse", 10),
            House(3, 78, 42.0, 1, 1, "Oak Street", "Apartment", 2),
            House(4, 10, 120.0, 9, 4, "Elm Street", "Penthouse", 15),
            House(5, 2, 85.0, 5, 3, "Maple Avenue", "Condominium", 8)
        ))

        println("Введите число комнат:")
        val roomsNum = readIntSafe(scanner)
        println("Введите нижнюю границу диапазона этажей:")
        val floorRangeFrom = readIntSafe(scanner)
        println("Введите верхнюю границу диапазона этажей:")
        val floorRangeTo = readIntSafe(scanner)
        val floorRange = floorRangeFrom..floorRangeTo
        println("Введите минимальную площадь:")
        val area = readDoubleSafe(scanner)

        houses.listApartmentsWithRooms(roomsNum)
        houses.listApartmentsWithRoomsAndFloor(roomsNum, floorRange)
        houses.listApartmentsWithAreaGreaterThan(area)
    } catch (e: InputMismatchException) {
        println("Ошибка ввода. Пожалуйста, введите корректные данные.")
    } catch (e: Exception) {
        println("Произошла ошибка: ${e.message}")
    } finally {
        scanner.close()
    }
}

fun readIntSafe(scanner: Scanner): Int {
    if (!scanner.hasNextInt()) throw InputMismatchException("Ожидалось целое число")
    return scanner.nextInt()
}

fun readDoubleSafe(scanner: Scanner): Double {
    if (!scanner.hasNextDouble()) throw InputMismatchException("Ожидалось число с плавающей точкой")
    return scanner.nextDouble()
}
