FROM eclipse-temurin:21-jdk-alpine
WORKDIR .
COPY . .
RUN ls -la .
COPY .jar/spring-boot-magic-0.0.1.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
