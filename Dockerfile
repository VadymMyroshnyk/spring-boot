FROM eclipse-temurin:21-jdk-alpine
VOLUME /tmp
COPY . .
WORKDIR .
RUN ./gradlew :spring-boot-magic:bootJar
RUN ls -la spring-boot-magic/build/libs
COPY spring-boot-magic/build/libs/spring-boot-magic-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
