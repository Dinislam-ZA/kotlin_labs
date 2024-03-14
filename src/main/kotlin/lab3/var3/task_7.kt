package lab3.var3

class Leaf(private var color: String = "green") {
    fun bloom() {
        color = "pink"
    }

    fun fall() {
        color = "brown"
    }

    fun frost() {
        color = "white"
    }

    fun yellow() {
        color = "yellow"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        other as Leaf
        return color == other.color
    }

    override fun hashCode(): Int {
        return color.hashCode()
    }

    override fun toString(): String {
        return "Leaf(color='$color')"
    }
}

class Tree(private val leaves: MutableList<Leaf> = mutableListOf()) {
    fun bloom() {
        leaves.forEach { it.bloom() }
    }

    fun fallLeaves() {
        leaves.clear()
    }

    fun frost() {
        leaves.forEach { it.frost() }
    }

    fun yellow() {
        leaves.forEach { it.yellow() }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        other as Tree
        return leaves == other.leaves
    }

    override fun hashCode(): Int {
        return leaves.hashCode()
    }

    override fun toString(): String {
        return "Tree(leaves=$leaves)"
    }
}

fun main() {
    val tree = Tree(mutableListOf(Leaf(), Leaf(), Leaf()))

    println("Исходное состояние дерева: $tree")

    tree.bloom()
    println("После зацветания: $tree")

    tree.yellow()
    println("Листья пожелтели: $tree")

    tree.frost()
    println("Листья покрылись инеем: $tree")

    tree.fallLeaves()
    println("Листья опали: $tree")
}
