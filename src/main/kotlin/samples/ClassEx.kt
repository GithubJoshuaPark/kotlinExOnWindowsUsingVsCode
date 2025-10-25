package main.kotlin.samples

import java.util.Scanner
import main.kotlin.utils.StringUtils

class Person(val name: String = "Joshua", val age: Int = 27) {
    val utils = StringUtils()    
    fun introduce() = utils.printLine("Hi, I'm $name, $age years old.")
}

class ClassEx {

    val utils = StringUtils()

    fun run() {
        utils.printLine("클래스 예제")

        val scanner = Scanner(System.`in`)
        println("Enter your name: ")
        val name = scanner.nextLine()
        println("Enter your age: ")
        val age = scanner.nextInt()

        val person = Person(name, age)
        person.introduce()
    }
}

