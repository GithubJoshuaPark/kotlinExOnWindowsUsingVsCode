# Kotlin Exercising on Windows os using vsCode

> VS Code에서 Kotlin을 “완전 기초부터” 실습할 수 있도록, 
> 설치부터 첫 실행·디버깅·기본 문법 연습까지 단계별로 안내

---

### 전체 로드맵 (개요)
1. JDK 17 LTS 설치 & 환경변수 설정
    Kotlin은 JDK 8 이상이 필요합니다. 
    기존 JDK 1.7은 유지하되, JDK 17을 추가 설치하고 JAVA_HOME을 전환합니다.

2. Kotlin 컴파일러(kotlinc) 설치
    Windows용 zip을 받아 C:\Kotlin\kotlinc 같은 경로에 두고 PATH에 추가합니다.

3. VS Code 확장 설치
    “Kotlin (fwcd)”, “Code Runner(선택)”, “Gradle for Java(선택)”

4. 첫 실습: Hello World
    단일 파일 컴파일/실행(두 방식)
        a) kotlinc로 컴파일 → java -jar로 실행
        b) 클래스패스 실행: kotlin -classpath out HelloKt

5. 기본 문법 미션
    val/var, 함수/when/반복, null-safety, data class, 컬렉션, 확장함수 순으로 짧은 과제 진행

---

### ✅ 1단계) JDK 17 LTS 설치 및 환경 변수 설정
    - 시작 메뉴 → “환경 변수 편집” 검색 → “환경 변수(N)…”
    - 시스템 변수에서 JAVA_HOME 만들고
    - 값: C:\Program Files\Java\jdk-17 (실제 설치 경로)
    - 시스템 변수의 Path 편집:
    - %JAVA_HOME%\bin 

```bash
# 새 터미널(명령 프롬프트) 열어 확인:
$ java -version → 17.x가 보여야 합니다.
$ javac -version → 17.x 확인.
```

### ✅ 2단계) Kotlin 컴파일러(kotlinc) 설치
> 목적: Kotlin 소스를 직접 컴파일하고 실행할 수 있도록 로컬 컴파일러 설치

```
2-1. 다운로드
    - 웹 브라우저에서 아래 주소로 이동:
    👉 https://github.com/JetBrains/kotlin/releases

    - 최신 Stable Release 중 kotlin-compiler-1.xx.xx.zip 파일을 
      다운로드합니다.
      (예: kotlin-compiler-2.0.21.zip)

2-2. 압축 해제
    예시 경로:
    C:\Kotlin\kotlinc

2-3. 환경변수 등록
    - 시작 → 환경 변수 편집 → 환경 변수(N)…
    - 시스템 변수 → Path → 편집
    새 항목 추가:
    C:\Kotlin\kotlinc\bin

    확인 후 새 cmd 창을 열어 아래 실행:
    $ kotlinc -version
    → info: kotlinc-jvm 2.0.x (JRE 17.x.x) 처럼 나오면 성공 🎉

2-4. Kotlin 파일 테스트
    - VS Code 또는 메모장에서 hello.kt 파일 생성:

    ```
    // 파일명: hello.kt
    fun main() {
        println("Hello, Kotlin!")
    }
    ```

    - 컴파일: (명령 프롬프트에서)
    ```
    $ kotlinc hello.kt -include-runtime -d hello.jar
    ```

    - 실행:
    ```
    $ java -jar hello.jar
    
    ```

```

> vsCode extension 설치
> 확장 이름	설명	설치 여부

```

| 확장 이름                          | 설명                                              | 설치 여부 |
| ---------------------------------- | ------------------------------------------------- | --------- |
| **Kotlin (by fwcd)**               | JetBrains 공식 지원 Kotlin Language Server (필수) | ✅ 필수    |
| **Code Runner (by Jun Han)**       | VSCode 내에서 코드 한 줄로 실행 (`Ctrl+Alt+N`)    | ⭐ 추천    |
| **Gradle for Java (by Microsoft)** | Gradle 기반 Kotlin 프로젝트 관리 시 편리          | ⚙️ 선택    |

```



```bash
# Project Structure
C:\Users\sorom\dev\kotlinEx
│
├─ 📁 src
│   ├─ 📁 main
│   │   └─ 📁 kotlin
│   │       ├─ Main.kt
│   │       └─ sample/
│   │           └─ Hello.kt
│   │
│   └─ 📁 test
│       └─ 📁 kotlin
│           └─ MainTest.kt
│
├─ 📁 bin
│   └─ (컴파일된 .class 파일 저장)
│
├─ 📁 libs
│   └─ (외부 라이브러리, 나중에 추가)
│
├─ 📄 build.bat      ← 직접 실행용 빌드 스크립트
├─ 📄 run.bat        ← 실행용 스크립트
├─ 📄 run.sh         ← build and run shell script
└─ 📄 README.md

# 폴더구조 만들기 (manually)
cd C:\Users\sorom\dev\kotlinEx

mkdir src
mkdir src\main
mkdir src\main\kotlin
mkdir src\main\kotlin\sample
mkdir src\test
mkdir src\test\kotlin
mkdir bin
mkdir libs

```

> 이제 build.bat → run.bat 순으로 실행하면
✅ Hello KotlinEx Project! 출력이 나오게 됩니다.