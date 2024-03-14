package lab3.var3

class Petal {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }

    override fun toString(): String {
        return "Petal()"
    }
}

class Bud(private var color: String = "green", private var isOpen: Boolean = false) {
    fun bloom() {
        isOpen = true
        color = "red"
    }

    fun wilt() {
        isOpen = false
        color = "brown"
    }

    fun printColor() {
        println("Цвет бутона: $color")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Bud

        if (color != other.color) return false
        if (isOpen != other.isOpen) return false

        return true
    }

    override fun hashCode(): Int {
        var result = color.hashCode()
        result = 31 * result + isOpen.hashCode()
        return result
    }

    override fun toString(): String {
        return "Bud(color='$color', isOpen=$isOpen)"
    }
}

class Rose(private val bud: Bud, private val petals: List<Petal>) {
    fun bloom() {
        bud.bloom()
    }

    fun wilt() {
        bud.wilt()
    }

    fun printBudColor() {
        bud.printColor()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Rose

        if (bud != other.bud) return false
        if (petals != other.petals) return false

        return true
    }

    override fun hashCode(): Int {
        var result = bud.hashCode()
        result = 31 * result + petals.hashCode()
        return result
    }

    override fun toString(): String {
        return "Rose(bud=$bud, petals=$petals)"
    }
}

fun main() {
    val rose1 = Rose(Bud("green", false), listOf(Petal(), Petal()))
    val rose2 = Rose(Bud("green", false), listOf(Petal(), Petal()))
    val rose3 = Rose(Bud("red", true), listOf(Petal()))

    println(rose1.toString())
    println(rose2.toString())
    println(rose3.toString())

    println("HashCode rose1: ${rose1.hashCode()}")
    println("HashCode rose2: ${rose2.hashCode()}")
    println("HashCode rose3: ${rose3.hashCode()}")

    println("rose1 == rose2: ${rose1 == rose2}")
    println("rose1 == rose3: ${rose1 == rose3}")

    rose1.bloom()
    println("После расцвета rose1: $rose1")
    println("rose1 == rose2 после изменения состояния rose1: ${rose1 == rose2}")
    rose3.wilt()
    println("После заведания rose3: $rose3")

    rose1.printBudColor()
    rose2.printBudColor()
    rose3.printBudColor()
}

