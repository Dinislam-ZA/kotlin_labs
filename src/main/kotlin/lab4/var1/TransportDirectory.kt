package lab4.var1



class TransportDirectory {
    private val routes = mutableListOf<Route>()

    fun addRoute(route: Route) {
        routes.add(route)
    }

    fun showInfo() {
        routes.forEach { route ->
            println("Маршрут: ${route.name}")
            println(" Время: с ${route.startTime} до ${route.endTime}")
            println(" Линии маршрутов: ${route.roads.joinToString()}")
            println(" Стоимость проезда: ${route.cost} руб.")
        }
    }

    inner class Route(val name: String, val startTime: String, val endTime: String, val cost: Int) {
        val roads = mutableListOf<String>()

        fun addRoad(road: String) {
            roads.add(road)
        }
    }
}

fun main() {
    val transportDirectory = TransportDirectory()

    val route1 = transportDirectory.Route("Маршрут 1", "08:00", "22:00", 50)
    route1.addRoad("Линия А")
    route1.addRoad("Линия Б")

    val route2 = transportDirectory.Route("Маршрут 2", "09:00", "23:00", 45)
    route2.addRoad("Линия В")
    route2.addRoad("Линия Г")

    transportDirectory.addRoute(route1)
    transportDirectory.addRoute(route2)

    transportDirectory.showInfo()
}
