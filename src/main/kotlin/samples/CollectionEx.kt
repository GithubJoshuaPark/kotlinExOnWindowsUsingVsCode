package main.kotlin.samples

import main.kotlin.utils.StringUtils

class CollectionEx {

    val utils = StringUtils()

    fun run() {
        utils.printLine("컬렉션 (List / Set / Map)")
        println("\n▶ 1. 불변 List")
        val fruits = listOf("Apple", "Banana", "Cherry", "Apple")
        println("fruits: $fruits")
        println("첫 번째 과일: ${fruits.first()}")
        println("마지막 과일: ${fruits.last()}")

        println("\n▶ 2. 가변 MutableList")
        val mutableFruits = mutableListOf("Apple", "Banana")
        mutableFruits.add("Grape")
        mutableFruits.remove("Apple")
        println("mutableFruits: $mutableFruits")

        println("\n▶ 3. Set (중복 불가)")
        val numbers = setOf(1, 2, 2, 3, 3, 3)
        println("numbers: $numbers (size=${numbers.size})")

        println("\n▶ 4. MutableSet (추가/삭제 가능)")
        val mutableNumbers = mutableSetOf(10, 20)
        mutableNumbers.add(30)
        mutableNumbers.add(20) // 중복 무시됨
        mutableNumbers.remove(10)
        println("mutableNumbers: $mutableNumbers")

        println("\n▶ 5. Map (Key-Value)")
        val capitals = mapOf(
            "Korea" to "Seoul",
            "Japan" to "Tokyo",
            "USA" to "Washington"
        )
        println("capitals: $capitals")
        println("Korea의 수도는 ${capitals["Korea"]}")

        println("\n▶ 6. MutableMap (값 변경 가능)")
        val ages = mutableMapOf(
            "Joshua" to 53,
            "Alice" to 24
        )
        ages["Bob"] = 30
        ages["Alice"] = 25
        println("ages: $ages")

        println("\n▶ 7. 컬렉션 순회")
        for ((country, capital) in capitals) {
            println("$country → $capital")
        }

        println("\n▶ 8. 고차함수(filter/map/sorted)")
        val numbers2 = listOf(5, 3, 8, 1, 2)
        val result = numbers2
            .filter { it > 3 }
            .sorted()
            .map { it * 2 }

        println("원본: $numbers2")
        println("결과(filter>3, sorted, *2): $result")

        println("\n▶ 9. any, all, none 예제")
        val scores = listOf(90, 85, 70, 60)
        println("모두 60점 이상인가? ${scores.all { it >= 60 }}")
        println("90점 이상이 하나라도 있는가? ${scores.any { it >= 90 }}")
        println("50점 미만은 없는가? ${scores.none { it < 50 }}")

        println("\n▶ 10. groupBy 예제")
        val names = listOf("Joshua", "Jane", "Jack", "Amy", "Alex")
        val grouped = names.groupBy { it.first() } // 첫 글자로 그룹화
        println("grouped by first letter: $grouped")

        println("\n[컬렉션 예제 완료]")
    }

}

