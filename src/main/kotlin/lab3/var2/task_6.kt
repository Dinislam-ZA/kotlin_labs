package lab3.var2

import common.IOHelper

class House(
    private var id: Int,
    private var apartmentNumber: Int,
    private var area: Double,
    private var floor: Int,
    private var numberOfRooms: Int,
    private var street: String,
    private var buildingType: String,
    private var operationTerm: Int
) {
    fun getId() = id
    fun setId(value: Int) {
        id = value
    }

    fun getApartmentNumber() = apartmentNumber
    fun setApartmentNumber(value: Int) {
        apartmentNumber = value
    }

    fun getArea() = area
    fun setArea(value: Double) {
        area = value
    }

    fun getFloor() = floor
    fun setFloor(value: Int) {
        floor = value
    }

    fun getNumberOfRooms() = numberOfRooms
    fun setNumberOfRooms(value: Int) {
        numberOfRooms = value
    }

    fun getStreet() = street
    fun setStreet(value: String) {
        street = value
    }

    fun getBuildingType() = buildingType
    fun setBuildingType(value: String) {
        buildingType = value
    }

    fun getOperationTerm() = operationTerm
    fun setOperationTerm(value: Int) {
        operationTerm = value
    }

    override fun toString(): String {
        return "House(id=$id, apartmentNumber=$apartmentNumber, area=$area, floor=$floor, " +
                "numberOfRooms=$numberOfRooms, street='$street', buildingType='$buildingType', " +
                "operationTerm=$operationTerm)"
    }
}

class Houses(val houses: Array<House>){
    fun listApartmentsWithRooms(rooms: Int) {
        println("Список квартир с заданным числом комнат")

        houses.filter { it.getNumberOfRooms() == rooms }
            .forEach { println(it) }
    }

    fun listApartmentsWithRoomsAndFloor(rooms: Int, floorRange: IntRange) {

        println("Список квартир с заданным числом комнат и этажом в промежутке")
        houses.filter { it.getNumberOfRooms() == rooms && it.getFloor() in floorRange }
            .forEach { println(it) }
    }

    fun listApartmentsWithAreaGreaterThan(area: Double) {
        println("Список квартир с площадью превышающей заданную ")

        houses.filter { it.getArea() > area }
            .forEach { println(it) }
    }
}

fun main() {
    val houses = Houses(arrayOf(
        House(1, 12, 55.0, 3, 2, "Green Street", "Apartment", 5),
        House(2, 45, 68.0, 6, 3, "Sunset Boulevard", "Townhouse", 10),
        House(3, 78, 42.0, 1, 1, "Oak Street", "Apartment", 2),
        House(4, 10, 120.0, 9, 4, "Elm Street", "Penthouse", 15),
        House(5, 2, 85.0, 5, 3, "Maple Avenue", "Condominium", 8)
    ))

    houses.houses.forEach {
        println(it)
    }

    println("Введите число комнат")
    val roomsNum = IOHelper.readIntMy(4)
    println("Введите промежуток этажей")
    val floorRangeFrom = IOHelper.readIntMy(4)
    val floorRangeTo = IOHelper.readIntMy(4)
    val floorRange = IntRange(floorRangeFrom, floorRangeTo)
    println("Введите площадь")
    val area = IOHelper.readDoubleMy(10.0)

    houses.listApartmentsWithRooms(roomsNum)
    houses.listApartmentsWithRoomsAndFloor(roomsNum, floorRange)
    houses.listApartmentsWithAreaGreaterThan(10.0)
}
