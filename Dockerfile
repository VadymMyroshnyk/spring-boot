FROM eclipse-temurin:21-jdk-alpine
EXPOSE 8080
WORKDIR .
COPY . .
RUN ls -la .
COPY .jar/spring-boot-magic-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
