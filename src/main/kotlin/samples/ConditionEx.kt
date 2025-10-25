package main.kotlin.samples

import java.util.Scanner
import main.kotlin.utils.StringUtils

class ConditionEx {

    val utils = StringUtils()

    fun run() {
        utils.printLine("[예제 2] 조건문 (if / when)")
        val score = 87
        val grade = if (score >= 90) "A"
                    else if (score >= 80) "B"
                    else "C"

        val message = when (grade) {
            "A" -> "Excellent!"
            "B" -> "Good job!"
            else -> "Keep trying!"
        }

        utils.printLine("Score: $score, Grade: $grade → $message")
    }    
}

