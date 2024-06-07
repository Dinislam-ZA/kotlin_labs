//import kotlinx.coroutines.sync.Mutex
//import kotlinx.coroutines.sync.withLock
//
//class BankAccount {
//    private var balance = 0
//    private val mutex = Mutex()
//
//    suspend fun deposit(amount: Int) {
//        mutex.withLock {
//            println("Пополнение счета на $amount. Текущий баланс: $balance")
//        }
//    }
//
//    suspend fun withdraw(amount: Int) {
//        mutex.withLock {
//            if (amount <= balance) {
//                balance -= amount
//                println("Снятие $amount. Текущий баланс: $balance")
//            } else {
//                println("Недостаточно средств для снятия $amount. Текущий баланс: $balance")
//            }
//        }
//    }
//}