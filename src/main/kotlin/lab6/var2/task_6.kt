package lab6.var2

data class Point(val x: Int, val y: Int)

fun findLines(points: List<Point>): Map<String, MutableList<Point>> {
    val lines = mutableMapOf<String, MutableList<Point>>()
    for (i in points.indices) {
        for (j in i + 1 until points.size) {
            val p1 = points[i]
            val p2 = points[j]
            val key = if (p1.x == p2.x) {
                "x=${p1.x}"  // вертикальная линия
            } else {
                val slope = (p2.y - p1.y).toDouble() / (p2.x - p1.x)
                val intercept = p1.y - slope * p1.x
                "y=${slope}x+$intercept"
            }
            lines.getOrPut(key) { mutableListOf() }.apply {
                add(p1)
                add(p2)
            }
        }
    }
    return lines
}

fun main() {
    val points = listOf(Point(0, 0), Point(1, 1), Point(2, 2), Point(3, 3), Point(1, 2))
    val lines = findLines(points)
    lines.forEach { (line, pts) ->
        println("Прямая $line проходит через точки: ${pts.distinct()}")
    }
}
