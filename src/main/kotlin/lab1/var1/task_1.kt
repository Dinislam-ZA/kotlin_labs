package lab1.var1

class Hello(val userName: String){
    fun helloUser(){
        println("Hello $userName !")
    }
}


fun main(){
    val name = "Zalimkhanov Dinislam Alievich"
    val hello = Hello(name)
    hello.helloUser()
}