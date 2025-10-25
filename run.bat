@echo off
set BIN_DIR=bin

echo Running App...
kotlin -classpath %BIN_DIR% main.kotlin.MainKt

pause