@echo off
set SRC_DIR=src\main\kotlin
set BIN_DIR=bin

echo Compiling Kotlin source...
kotlinc %SRC_DIR% -d %BIN_DIR%

echo Done.
pause