package main.kotlin

import java.util.Scanner

import main.kotlin.samples.VariableEx 
import main.kotlin.samples.ConditionEx
import main.kotlin.samples.LoopsEx
import main.kotlin.samples.FunctionsEx
import main.kotlin.samples.ClassEx

import main.kotlin.utils.StringUtils


fun main() {
    val scanner = Scanner(System.`in`)
    val utils = StringUtils()

    val variableEx = VariableEx()
    val conditionEx = ConditionEx()
    val loopsEx = LoopsEx()
    val functionsEx = FunctionsEx()
    val classEx = ClassEx()
    
    
    while (true) {
        utils.printLine(" Kotlin Basic Practice Menu ")
        println("1. 변수 (val / var) 예제")
        println("2. 조건문 (if / when) 예제")
        println("3. 반복문 (for / while) 예제")
        println("4. 함수 예제")
        println("5. 클래스 예제")
        println("0. 종료")
        print("번호를 입력하세요: ")

        when (scanner.nextLine().trim()) {
            "1" -> variableEx.run()
            "2" -> conditionEx.run()
            "3" -> loopsEx.run()
            "4" -> functionsEx.run()
            "5" -> classEx.run()
            "0" -> {
                println("프로그램을 종료합니다.")
                break
            }
            else -> println("잘못된 입력입니다. 다시 입력하세요.")
        }

        println("\n엔터를 누르면 메뉴로 돌아갑니다...")
        scanner.nextLine()
    }
}