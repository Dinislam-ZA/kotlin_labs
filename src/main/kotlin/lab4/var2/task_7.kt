package lab4.var2

interface Doctor {
    fun diagnose()
}

abstract class Surgeon : Doctor {
    override fun diagnose() {
        println("Diagnosing as a surgeon.")
    }

    open fun performSurgery() {
        println("Performing surgery.")
    }
}

class Neurosurgeon : Surgeon() {
    override fun performSurgery() {
        println("Performing neurosurgery.")
    }

    fun performBrainSurgery() {
        println("Performing brain surgery specifically.")
    }
}

fun main() {
    val neurosurgeon = Neurosurgeon()
    neurosurgeon.diagnose()
    neurosurgeon.performSurgery()
    neurosurgeon.performBrainSurgery()
}

