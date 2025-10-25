@echo off
set BIN_DIR=bin
set LIB_DIR=libs
set CLASSPATH=%BIN_DIR%;%LIB_DIR%\kotlinx-coroutines-core-jvm-1.8.0.jar;%LIB_DIR%\kotlinx-serialization-core-1.7.3.jar;%LIB_DIR%\kotlinx-serialization-json-1.7.3.jar

echo Running Kotlin app...
kotlin -classpath "%BIN_DIR%;%LIB_DIR%\kotlinx-coroutines-core-jvm-1.8.2.jar;%LIB_DIR%\kotlinx-serialization-core-1.7.3.jar;%LIB_DIR%\kotlinx-serialization-json-1.7.3.jar" main.kotlin.MainKt

echo ✅ Program finished.
pause