package main.kotlin.samples

import main.kotlin.utils.StringUtils

class LambdaEx {

    val utils = StringUtils()

    fun run() {
        utils.printLine("람다 표현식 / 고차 함수 / 익명 함수")

        println("\n▶ 1. 기본 람다 정의")
        val greet: (String) -> String = { name -> "Hello, $name!" }
        println(greet("Joshua"))

        println("\n▶ 2. 매개변수가 1개면 it으로 생략 가능")
        val square: (Int) -> Int = { it * it }
        println("5의 제곱 = ${square(5)}")

        println("\n▶ 3. 고차 함수 (함수를 인자로 받는 함수)")
        fun operate(x: Int, y: Int, op: (Int, Int) -> Int): Int {
            return op(x, y)
        }

        val sum = operate(3, 4) { a, b -> a + b }
        val product = operate(3, 4) { a, b -> a * b }
        println("3 + 4 = $sum, 3 * 4 = $product")

        println("\n▶ 4. 함수를 반환하는 함수 (고차함수의 또 다른 형태)")
        fun chooseOperator(type: String): (Int, Int) -> Int {
            return when (type) {
                "add" -> { a, b -> a + b }
                "sub" -> { a, b -> a - b }
                else -> { _, _ -> 0 }
            }
        }

        val addOp = chooseOperator("add")
        val subOp = chooseOperator("sub")
        println("addOp(5,2) = ${addOp(5,2)}, subOp(5,2) = ${subOp(5,2)}")

        println("\n▶ 5. 익명 함수 (anonymous function)")
        val multiply = fun(a: Int, b: Int): Int = a * b
        println("multiply(3, 6) = ${multiply(3, 6)}")

        println("\n▶ 6. Collection + 람다 활용 예제")
        val numbers = listOf(1, 2, 3, 4, 5)
        val doubled = numbers.map { it * 2 }
        val evenSum = numbers.filter { it % 2 == 0 }.sum()
        println("numbers: $numbers")
        println("doubled: $doubled")
        println("짝수 합계: $evenSum")

        println("\n▶ 7. with / apply / run / also 차이 요약")
        val sb = StringBuilder().apply {
            append("Joshua")
            append(" loves Kotlin")
        }.also {
            println("현재 문자열 길이: ${it.length}")
        }.run {
            this.toString().uppercase()
        }.let {
            "최종 결과: $it"
        }
        println(sb)

        println("\n[람다 표현식 예제 완료]")
    }

}

