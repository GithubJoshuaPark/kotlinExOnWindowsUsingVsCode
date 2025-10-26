import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

plugins {
    kotlin("jvm") version "2.0.21"
    kotlin("plugin.serialization") version "2.0.21"
    application
}

repositories { mavenCentral() }

dependencies {
    // ✅ 코루틴 및 직렬화 라이브러리
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
}

application {
    // ✅ Kotlin main 함수 위치
    mainClass.set("main.kotlin.MainKt")
}

// ----------------------------------------------------------
// ✅ 빌드 정보 자동 삽입: version, author, build time
// ----------------------------------------------------------
val appName = "kotlinEx"
val appVersion = "1.0.0"
val appAuthor = "Joshua Park"
val buildDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))
val buildTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))

// ----------------------------------------------------------
// ✅ fat jar (독립 실행형) 생성 설정
// ----------------------------------------------------------
tasks.jar {
    val jarFileName = "${appName}-v${appVersion}-${buildDate}-standalone.jar"

    manifest {
        //attributes["Main-Class"] = "main.kotlin.MainKt"
        attributes(
            "Main-Class" to "main.kotlin.MainKt",
            "Implementation-Title" to appName,
            "Implementation-Version" to appVersion,
            "Built-By" to appAuthor,
            "Build-Time" to buildTime
        )
    }

    archiveFileName.set(jarFileName)
    // ✅ 모든 런타임 종속 라이브러리를 포함 (Fat Jar)
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })

}

// ----------------------------------------------------------
// ✅ build 후 자동 실행 (latest jar 실행)
// ----------------------------------------------------------
tasks.register("runLatestJar") {
    dependsOn("build")

   // buildDir: “현재 프로젝트의 빌드 출력 폴더 경로” (ex: C:\Users\sorom\dev\kotlinEx\build)
    doLast {
        val libsDir = file("$buildDir/libs")
        val latestJar = libsDir.listFiles()
            ?.filter { it.extension == "jar" }
            ?.maxByOrNull { it.lastModified() }

        if (latestJar != null) {
            println("▶ 실행 중: ${latestJar.name}")
            val process = ProcessBuilder("java", "-jar", latestJar.absolutePath)
                .inheritIO() // 콘솔 입출력 연결
                .start()

            // ✅ 자식 프로세스가 끝날 때까지 대기 (출력 정상 표시)
            process.waitFor()
        } else {
            println("⚠️ JAR 파일을 찾을 수 없습니다.")
        }
    }
}
