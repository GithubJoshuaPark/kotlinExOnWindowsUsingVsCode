@echo off
set SRC_DIR=src\main\kotlin
set BIN_DIR=bin
set LIB_DIR=libs
set CLASSPATH=%LIB_DIR%\kotlinx-coroutines-core-jvm-1.8.0.jar;%LIB_DIR%\kotlinx-serialization-core-1.7.3.jar;%LIB_DIR%\kotlinx-serialization-json-1.7.3.jar

echo Compiling Kotlin sources with coroutine and serialization support...
kotlinc %SRC_DIR% -d %BIN_DIR% ^
 -classpath "%LIB_DIR%\kotlinx-coroutines-core-jvm-1.8.0.jar;%LIB_DIR%\kotlinx-serialization-core-1.7.3.jar;%LIB_DIR%\kotlinx-serialization-json-1.7.3.jar" ^
 -Xplugin="%LIB_DIR%\kotlin-serialization-2.0.21.jar" ^
 -include-runtime

echo ✅ Build complete.
pause