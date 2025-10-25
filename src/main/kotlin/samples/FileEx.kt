package main.kotlin.samples

import java.io.File
import java.io.IOException

import main.kotlin.utils.StringUtils

class FileEx {

    val utils = StringUtils()

    fun run() {
        utils.printLine("파일 입출력 (File I/O)")

        val baseDir = "C:\\Users\\sorom\\dev\\kotlinEx\\data"
        val filePath = "$baseDir\\example.txt"

        // 디렉터리 확인 및 생성
        val dir = File(baseDir)
        if (!dir.exists()) {
            dir.mkdirs()
            println("📁 폴더 생성: ${dir.absolutePath}")
        }

        println("\n▶ 1. 파일에 텍스트 쓰기 (overwrite)")
        val content = "Hello Kotlin File!\nThis is a file I/O example."
        try {
            File(filePath).writeText(content)
            println("파일 작성 완료: $filePath")
        } catch (e: IOException) {
            println("쓰기 오류: ${e.message}")
        }

        println("\n▶ 2. 파일에 내용 추가 (append)")
        try {
            File(filePath).appendText("\nAppended line at ${System.currentTimeMillis()}")
            println("내용 추가 완료.")
        } catch (e: IOException) {
            println("추가 오류: ${e.message}")
        }

        println("\n▶ 3. 파일 읽기")
        try {
            val text = File(filePath).readText()
            println("파일 내용:\n$text")
        } catch (e: IOException) {
            println("읽기 오류: ${e.message}")
        }

        println("\n▶ 4. 파일 줄 단위 읽기")
        val lines = File(filePath).readLines()
        println("총 ${lines.size}줄:")
        lines.forEachIndexed { index, line ->
            println("${index + 1}: $line")
        }

        println("\n▶ 5. 파일 존재 여부 및 삭제")
        val file = File(filePath)
        if (file.exists()) {
            println("파일 존재: ${file.absolutePath}")
            // 삭제는 주석 해제 시 실행됨
            // file.delete()
            // println("파일 삭제 완료.")
        } else {
            println("파일이 존재하지 않습니다.")
        }

        println("\n[파일 입출력 예제 완료]")
    }

}

