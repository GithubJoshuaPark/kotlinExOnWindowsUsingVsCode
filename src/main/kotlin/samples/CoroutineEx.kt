package main.kotlin.samples

import kotlinx.coroutines.*
import main.kotlin.utils.StringUtils

class CoroutineEx {

    val utils = StringUtils()

    // suspend 함수 예시 1
    private suspend fun getUser(): String {
        delay(1000L)
        return "Joshua (비동기 사용자 정보)"
    }

    // suspend 함수 예시 2
    private suspend fun fetchData(): String {
        delay(1200L)
        return "서버 데이터 로드 완료"
    }

    // suspend 함수 예시 3
    private suspend fun writeLog(): String {
        delay(800L)
        return "로그 기록 완료"
    }

    fun run() = runBlocking {
        utils.printLine("Coroutine (비동기 처리 기초)")

         println("메인 스레드: ${Thread.currentThread().name}")

        println("\n▶ 1. launch - 결과를 반환하지 않는 비동기 작업")
        val job = launch {
            println("[launch] 시작: ${Thread.currentThread().name}")
            delay(1000L)
            println("[launch] 완료: 1초 후 실행됨")
        }
        println("→ 메인 스레드는 job이 끝나길 기다리지 않고 계속 진행")
        job.join() // 명시적으로 기다리기

        println("\n▶ 2. async - 결과를 반환하는 비동기 작업")
        val result = async {
            delay(500L)
            println("[async] 내부 계산 중...")
            3 + 5
        }
        println("async 결과: ${result.await()}") // await()으로 결과 대기

        println("\n▶ 3. suspend 함수 호출")
        val user = getUser()
        println("suspend getUser() → $user")

        println("\n▶ 4. 여러 비동기 작업 병렬 실행")
        val start = System.currentTimeMillis()
        val dataDeferred = async { fetchData() }
        val logDeferred = async { writeLog() }
        println("결과 수신: ${dataDeferred.await()}")
        println("로그 완료: ${logDeferred.await()}")
        val time = System.currentTimeMillis() - start
        println("총 소요 시간: ${time}ms (동시 실행 확인)")

        println("\n▶ 5. withContext - 다른 디스패처에서 실행")
        withContext(Dispatchers.Default) {
            println("백그라운드 스레드에서 무거운 연산 중... [${Thread.currentThread().name}]")
            delay(800L)
        }
        println("메인 스레드로 복귀 [${Thread.currentThread().name}]")

        println("\n[Coroutine 예제 완료]")
    }

}

