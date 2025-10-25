package main.kotlin.samples

import main.kotlin.utils.StringUtils

class VariableEx {

    val utils = StringUtils()

    fun run() {
        utils.printLine("변수 (val / var)")
        val name = "Joshua"   // val is like constant
        var city = "Incheon"  // var is mutable
        city = "Seoul"
        println("Name: $name, City: $city")
    }

}

