package lab4.var2

interface Ship {
    fun sail()
}

abstract class MilitaryShip : Ship {
    abstract fun fireWeapon()
}

class AircraftCarrier : MilitaryShip() {
    override fun sail() {
        println("The aircraft carrier is sailing.")
    }

    override fun fireWeapon() {
        println("The aircraft carrier fires its weapons.")
    }

    fun launchAircraft() {
        println("Launching aircraft.")
    }
}

fun main() {
    val aircraftCarrier = AircraftCarrier()

    aircraftCarrier.sail()
    aircraftCarrier.fireWeapon()
    aircraftCarrier.launchAircraft()
}
