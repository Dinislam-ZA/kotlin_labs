//import kotlinx.coroutines.*
//import kotlin.random.Random
//
//fun main() = runBlocking {
//    val store = Store()
//    val producer = launch(Dispatchers.Default) {
//        while (isActive) {
//            val quantity = Random.nextInt(1, 10)
//            store.addProduct(quantity)
//            delay(1000)
//        }
//    }
//    val consumer = launch(Dispatchers.Default) {
//        while (isActive) {
//            val quantity = Random.nextInt(1, 10)
//            store.buyProduct(quantity)
//            delay(1500)
//        }
//    }
//
//    delay(10000)
//    producer.cancel()
//    consumer.cancel()
//
//    val account = BankAccount()
//    val jobDeposit = launch(Dispatchers.Default) {
//        repeat(10) {
//            account.deposit(Random.nextInt(100, 500))
//            delay(200)
//        }
//    }
//    val jobWithdraw = launch(Dispatchers.Default) {
//        repeat(10) {
//            account.withdraw(Random.nextInt(100, 500))
//            delay(300)
//        }
//    }
//
//    delay(10000)
//    jobDeposit.cancel()
//    jobWithdraw.cancel()
//}
//
