package main.kotlin.samples

import main.kotlin.utils.StringUtils

class NullEx {

    val utils = StringUtils()

    data class Address(val city: String, val district: String)
    data class User(val name: String, val address: Address)

    class Profile {
        var name: String? = null
        var age: Int? = null
    }

    fun run() {
        utils.printLine("Null-Safety (널 안정성)")
        println("\n▶ 1. Kotlin의 기본 원칙: 변수는 기본적으로 null 불가")
        // var name: String = null // ❌ 오류 발생
        var name: String = "Joshua"
        println("name = $name")

        println("\n▶ 2. null 허용 변수는 타입 뒤에 '?' 추가")
        var nickname: String? = null
        println("nickname = $nickname")

        println("\n▶ 3. Safe call operator (?.)")
        // null일 경우 호출을 생략하고 null을 반환함
        println("nickname length = ${nickname?.length}")

        nickname = "soromiso"
        println("nickname length = ${nickname?.length}")

        println("\n▶ 4. Elvis operator (?:) — null일 때 기본값 사용")
        nickname = null
        val displayName = nickname ?: "익명 사용자"
        println("표시 이름: $displayName")

        println("\n▶ 5. Non-null assertion ( !! ) — null이면 예외 발생")
        try {
            val len = checkNotNull(nickname) {"닉네임이 null입니다."}
            println("nickname length = $len")
        } catch (e: Exception) {
            println("예외 발생: ${e.message}")
        }

        println("\n▶ 6. let 함수 — null이 아닐 때만 블록 실행")
        nickname = "JoshuaPark"
        nickname?.let {
            println("닉네임이 존재합니다: $it (${it.length}자)")
        }

        println("\n▶ 7. also 함수 — 객체를 그대로 반환하면서 부가 작업 수행")
        val text = "kotlin"
            .also { println("원본 문자열: $it") }
            .uppercase()
        println("대문자로 변환된 문자열: $text")

        println("\n▶ 8. Safe-call 체이닝 (?. 연속 호출)")
        val user: User? = User("Joshua", Address("Incheon", "Seo-gu"))
        println("도시명: ${user?.address?.city}")
        val user2: User? = null
        println("도시명(널 객체): ${user2?.address?.city}")

        println("\n▶ 9. apply와 run — 객체 초기화와 스코프 처리")
        val profile = Profile().apply {
            name = "Joshua"
            age = 53
        }.run {
            "이름: $name, 나이: $age"
        }
        println(profile)

        println("\n[Null-safety 예제 완료]")
    }

}

