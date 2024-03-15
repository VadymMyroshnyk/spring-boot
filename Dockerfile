FROM eclipse-temurin:21-jdk-alpine
WORKDIR .
COPY . .
RUN ls -la .
COPY .jar/spring-boot-magic-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
