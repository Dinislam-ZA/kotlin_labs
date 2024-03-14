package lab3.var4

data class Subscriber(var name: String, var phoneNumber: String, var services: MutableList<Service> = mutableListOf()) {
    fun payBill(bill: Bill) {
        println("$name оплатил счет на сумму ${bill.amount}")
    }

    fun requestNumberChange(newNumber: String, administrator: Administrator) {
        administrator.changePhoneNumber(this, newNumber)
    }

    fun cancelService(service: Service, administrator: Administrator) {
        administrator.changeServices(this, service, false)
    }
}

data class Bill(val amount: Double, val subscriber: Subscriber)

class Administrator {
    fun changePhoneNumber(subscriber: Subscriber, newNumber: String) {
        subscriber.phoneNumber = newNumber
        println("Номер абонента ${subscriber.name} изменен на $newNumber")
    }

    fun changeServices(subscriber: Subscriber, service: Service, addService: Boolean) {
        if (addService) {
            subscriber.services.add(service)
            println("Услуга ${service.name} добавлена абоненту ${subscriber.name}")
        } else {
            if (subscriber.services.remove(service))
                println("Услуга ${service.name} отменена для абонента ${subscriber.name}")
            else
                println("Услуга не подключена")
        }
    }

    fun temporarilyDisconnect(subscriber: Subscriber) {
        println("Абонент ${subscriber.name} временно отключен за неуплату")
    }
}

data class Service(val name: String)

fun main() {
    val service = Service("Интернет")
    val subscriber = Subscriber("Иван Иванов", "89123456789", mutableListOf(service))
    println(subscriber)
    val bill = Bill(1500.0, subscriber)
    val administrator = Administrator()

    subscriber.payBill(bill)
    subscriber.requestNumberChange("89123456700", administrator)
    subscriber.cancelService(service, administrator)

    administrator.changeServices(subscriber, service, true)
    administrator.temporarilyDisconnect(subscriber)
}
