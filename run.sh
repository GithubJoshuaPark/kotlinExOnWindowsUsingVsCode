#!/bin/bash
# ===============================================
# KotlinEx build & run script
# Author : Joshua Park
# Date   : $(date +%Y-%m-%d)
# ===============================================

# 1️⃣ Gradle 빌드 (clean + build)
echo "🧱 Building project with Gradle..."
gradle clean build --quiet

# 빌드 성공 여부 확인
if [ $? -ne 0 ]; then
  echo "❌ Build failed. Check Gradle logs."
  exit 1
fi

# 2️⃣ 최신 JAR 파일 찾기
LATEST_JAR=$(ls -t ./build/libs/*.jar | head -n 1)

if [ -z "$LATEST_JAR" ]; then
  echo "⚠️ No JAR file found in ./build/libs/"
  exit 1
fi

# 3️⃣ 실행
echo "🚀 Running latest JAR: $LATEST_JAR"
echo "------------------------------------------"
java -jar "$LATEST_JAR"
