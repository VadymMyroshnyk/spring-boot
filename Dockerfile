FROM eclipse-temurin:21-jdk-alpine
VOLUME /tmp
CMD ["./gradlew", "clean", ":spring-boot-magic:bootJar"]
COPY spring-boot-magic/build/libs/spring-boot-magic-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
