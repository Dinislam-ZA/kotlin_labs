//import kotlinx.coroutines.sync.Mutex
//import kotlinx.coroutines.sync.withLock
//
//class Store {
//    private var stock = 0
//    private val mutex = Mutex()
//
//    suspend fun addProduct(quantity: Int) {
//        mutex.withLock {
//            stock += quantity
//            println("Производитель добавил $quantity продукт(ов). На складе: $stock")
//        }
//    }
//
//    suspend fun buyProduct(quantity: Int) {
//        mutex.withLock {
//            if (stock < quantity) {
//                println("Недостаточно товара для покупателя. На складе: $stock")
//            }
//            else{
//                stock -= quantity
//                println("Покупатель купил $quantity продукт(ов). Остаток на складе: $stock")
//            }
//        }
//    }
//}