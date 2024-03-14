package common

import java.util.ArrayList

object IOHelper {

    fun readIntMy(caseNullNum: Int) = readlnOrNull()?.toIntOrNull() ?: caseNullNum

    fun readFloatMy(caseNullNum: Float) = readlnOrNull()?.toFloatOrNull() ?: caseNullNum

    fun readDoubleMy(caseNullNum: Double) = readlnOrNull()?.toDoubleOrNull() ?: caseNullNum

    fun arrayFloatInput(n: Int): List<Double>{
        val array = mutableListOf<Double>()
        for(i in 1..n){
            println("Введите элемент массива под номером $i")
            val num = readDoubleMy(0.0)
            array += num
        }
        return array
    }

}