package main.kotlin.samples

import java.util.Scanner
import main.kotlin.utils.StringUtils

class FunctionsEx {

    val utils = StringUtils()

    private fun add(a: Int, b: Int): Int = a + b
    private fun greet(name: String) = "Hello, $name!"

    fun run() {
        utils.printLine("[예제 4] 함수 예제")
        println("add(3, 5) = ${add(3, 5)}")
        println(greet("Joshua"))
    }
}
