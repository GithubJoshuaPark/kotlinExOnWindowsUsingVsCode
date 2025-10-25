package main.kotlin.samples

import java.util.Scanner
import main.kotlin.utils.StringUtils

class LoopsEx {

    val utils = StringUtils()

    fun run() {
        utils.printLine("[예제 3] 반복문 (for / while)")
        for (i in 1..5) println("i = $i")
        var count = 0
        while (count < 3) {
            println("count = $count")
            count++
        }
    }

}
