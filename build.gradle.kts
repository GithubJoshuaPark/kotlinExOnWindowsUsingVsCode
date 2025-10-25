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
val buildTime: String = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
val appVersion = "1.0.0"
val appAuthor = "Joshua Park"

// ✅ JAR 생성 시 메인 클래스 속성 추가
tasks.jar {
    manifest {
        //attributes["Main-Class"] = "main.kotlin.MainKt"
        attributes(
            "Main-Class" to "main.kotlin.MainKt",
            "Implementation-Title" to "KotlinEx",
            "Implementation-Version" to appVersion,
            "Built-By" to appAuthor,
            "Build-Time" to buildTime
        )
    }

    // ✅ 모든 런타임 종속 라이브러리를 포함 (Fat Jar)
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })

    archiveFileName.set("kotlinEx-standalone.jar")
}
