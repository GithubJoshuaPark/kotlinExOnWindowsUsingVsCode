package main.kotlin.samples

import java.io.File
import java.io.IOException
import kotlinx.serialization.*
import kotlinx.serialization.json.*

import main.kotlin.utils.StringUtils

@Serializable
data class User(val name: String, val age: Int, val city: String)

class JsonFileEx {

    val utils = StringUtils()

    fun run() {
        utils.printLine("Json 파일 입출력 예제")

        val baseDir = "C:\\Users\\sorom\\dev\\kotlinEx\\data"
        // ✅ textFile, jsonFile 명시적으로 선언
        val textFile = "$baseDir\\example.txt"
        val jsonFile = "$baseDir\\user.json"

        // 디렉터리 확인 및 생성
        val dir = File(baseDir)
        if (!dir.exists()) {
            dir.mkdirs()
            println("📁 폴더 생성: ${dir.absolutePath}")
        }

        // 텍스트 파일 예제
        println("\n▶ 1. 텍스트 파일 작성 및 읽기")
        File(textFile).writeText("Hello Kotlin!\nThis is a text file example.")
        println(File(textFile).readText())

        // JSON 파일 예제
        println("\n▶ 2. JSON 파일 저장")
        val user = User("Joshua", 53, "Incheon")
        val jsonString = Json.encodeToString(user)
        File(jsonFile).writeText(jsonString)
        println("user.json 파일 생성 완료: ${File(jsonFile).absolutePath}")

        println("\n▶ 3. JSON 파일 읽기")
        val readJson = File(jsonFile).readText()
        val decodedUser = Json.decodeFromString<User>(readJson)
        println("디코딩 결과: name=${decodedUser.name}, age=${decodedUser.age}, city=${decodedUser.city}")

        println("\n▶ 4. JSON 배열 예제")
        val users = listOf(
            User("Joshua", 53, "Incheon"),
            User("Alice", 24, "Busan"),
            User("Bob", 30, "Seoul")
        )
        val jsonArrayString = Json.encodeToString(users)
        File("$baseDir\\users.json").writeText(jsonArrayString)
        println("users.json 작성 완료.")

        val decodedList = Json.decodeFromString<List<User>>(File("$baseDir\\users.json").readText())
        println("JSON 배열 파싱 결과:")
        decodedList.forEachIndexed { i, u ->
            println("${i + 1}. ${u.name} (${u.age}), ${u.city}")
        }

        println("\n[파일 + JSON 입출력 예제 완료]")
    }

}

