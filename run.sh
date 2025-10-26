#!/bin/bash
# ===============================================
# KotlinEx Auto Build & Run Script (v2.0)
# Author : Joshua Park
# Updated: $(date +%Y-%m-%d)
# ===============================================

# 기본값
CLEAN_BUILD=true
DEBUG_MODE=false
WATCH_MODE=false

# 인자 처리
for arg in "$@"; do
  case $arg in
    --fast)
      CLEAN_BUILD=false
      ;;
    --debug)
      DEBUG_MODE=true
      ;;
    --watch)
      WATCH_MODE=true
      ;;
    *)
      ;;
  esac
done

# 1️⃣ 빌드 단계
echo "🧱 Building project with Gradle..."

if [ "$CLEAN_BUILD" = true ]; then
  CMD="gradle clean build"
else
  CMD="gradle build"
fi

if [ "$DEBUG_MODE" = false ]; then
  CMD="$CMD --quiet"
fi

eval $CMD
BUILD_RESULT=$?

if [ $BUILD_RESULT -ne 0 ]; then
  echo "❌ Build failed. Check Gradle logs."
  exit 1
fi

# 2️⃣ 최신 JAR 탐색
LATEST_JAR=$(ls -t ./build/libs/*.jar | head -n 1)

if [ -z "$LATEST_JAR" ]; then
  echo "⚠️ No JAR file found in ./build/libs/"
  exit 1
fi

# 3️⃣ 실행 함수
run_jar() {
  echo "🚀 Running latest JAR: $LATEST_JAR"
  echo "------------------------------------------"
  java -jar "$LATEST_JAR"
}

# 4️⃣ watch 모드 (변경 시 자동 빌드)
if [ "$WATCH_MODE" = true ]; then
  echo "👀 Watch mode enabled — source changes trigger rebuilds"
  echo "Press [Ctrl+C] to stop watching."
  while true; do
    inotifywait -r -e modify,create,delete ./src >/dev/null 2>&1
    clear
    bash "$0" --fast
  done
else
  run_jar
fi
