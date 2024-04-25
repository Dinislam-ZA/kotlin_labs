package lab6.var2
import java.util.TreeMap

data class MyLine(val a: Double, val b: Double) // Представление отрезка как y = ax + b

data class MyPoint(val x: Double, val y: Double)

fun findIntersection(l1: MyLine, l2: MyLine): MyPoint? {
    if (l1.a == l2.a) {
        return null // Линии параллельны, если угловые коэффициенты равны
    }

    val x = (l2.b - l1.b) / (l1.a - l2.a)
    val y = l1.a * x + l1.b

    return MyPoint(x, y)
}

fun findMinimumXIntersection(lines: List<MyLine>): MyPoint? {
    val intersections = TreeMap<Double, MyPoint>()

    for (i in lines.indices) {
        for (j in i + 1 until lines.size) {
            val l1 = lines[i]
            val l2 = lines[j]
            val intersection = findIntersection(l1, l2)
            intersection?.let {
                intersections[it.x] = it
            }
        }
    }

    return intersections.firstEntry()?.value
}

fun main() {
    val lines = listOf(
        MyLine(1.0, 0.0),
        MyLine(-1.0, 4.0),
        MyLine(0.5, 1.0),
        MyLine(2.0, -1.0)
    )
    val intersection = findMinimumXIntersection(lines)
    if (intersection != null) {
        println("Точка пересечения с минимальной абсциссой это: (${intersection.x}, ${intersection.y})")
    } else {
        println("Нет пересечений")
    }
}
