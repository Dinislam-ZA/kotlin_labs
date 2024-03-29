package lab4.var1

class Shop(private val name: String) {
    private val departments = mutableListOf<Department>()

    fun addDepartment(department: Department) {
        departments.add(department)
    }

    fun listDepartments() {
        println("Shop: $name")
        departments.forEach { department ->
            println("Department: ${department.name}")
            println(" Products:")
            department.products.forEach { product ->
                println("  - $product")
            }
            println(" Services:")
            department.services.forEach { service ->
                println("  - $service")
            }
        }
    }

    inner class Department(val name: String) {
        val products = mutableListOf<String>()
        val services = mutableListOf<String>()

        fun addProduct(product: String) {
            products.add(product)
        }

        fun addService(service: String) {
            services.add(service)
        }
    }
}

fun main() {
    val myShop = Shop("My Super Shop")
    val electronics = myShop.Department("Electronics")
    electronics.addProduct("Smartphone")
    electronics.addProduct("Laptop")
    electronics.addService("Warranty extension")

    val groceries = myShop.Department("Groceries")
    groceries.addProduct("Bread")
    groceries.addProduct("Milk")

    myShop.addDepartment(electronics)
    myShop.addDepartment(groceries)

    myShop.listDepartments()
}
