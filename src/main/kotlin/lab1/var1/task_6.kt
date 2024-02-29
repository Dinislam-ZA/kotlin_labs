package lab1.var1

import java.text.SimpleDateFormat
import java.util.Calendar


fun main(){
    val name = "Zalimkhanov Dinislam Alievich"

    val time = Calendar.getInstance().time
    val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm")
    val submitDate = formatter.format(time)
    val getLabDate = "2024-02-09 14:00"
    println("$name get lab on $getLabDate and submit it on $submitDate")
}