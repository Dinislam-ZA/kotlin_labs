package lab3.var4

data class TechnicalSpecification(val requirements: String)

data class Client(val name: String)

data class Invoice(val amount: Double, val client: Client)

data class DesignTeam(val members: List<String>)

data class Project(val specification: TechnicalSpecification, val cost: Double)

class Designer {
    fun registerSpecification(specification: TechnicalSpecification): Project {
        val projectCost = calculateCost(specification)
        return Project(specification, projectCost)
    }

    fun calculateCost(specification: TechnicalSpecification): Double {
        val baseCost = 50000.0
        val costPerWord = 100.0
        val wordCount = specification.requirements.split(" ").size
        return baseCost + (wordCount * costPerWord)
    }

    fun issueInvoice(client: Client, project: Project): Invoice {
        return Invoice(project.cost, client)
    }

    fun createDesignTeam(): DesignTeam {
        return DesignTeam(listOf("Designer 1", "Designer 2"))
    }
}

fun main() {
    val client = Client("Заказчик 1")
    val designer = Designer()
    val specification = TechnicalSpecification("Требования к дому")

    val project = designer.registerSpecification(specification)
    val invoice = designer.issueInvoice(client, project)
    val team = designer.createDesignTeam()

    println("Создан проект: $project")
    println("Выставлен счет: $invoice")
    println("Создана бригада конструкторов: $team")
}

