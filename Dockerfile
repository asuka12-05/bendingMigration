FROM eclipse-temurin:21-jdk-jammy as builder
WORKDIR /workspace/app
COPY . .
RUN ./gradlew bootJar

FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=builder /workspace/app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]