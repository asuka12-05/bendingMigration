FROM eclipse-temurin:21-jdk-jammy AS builder
WORKDIR /workspace/app
COPY . .
# 実行権限を付与する
RUN chmod +x gradlew
RUN ./gradlew bootJar

FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=builder /workspace/app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]