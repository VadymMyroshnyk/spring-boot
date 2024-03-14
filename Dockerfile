FROM eclipse-temurin:21-jdk-alpine
VOLUME /tmp
COPY . .
WORKDIR .
RUN ./gradlew :spring-boot-magic:bootJar
WORKDIR spring-boot-magic/build/libs
RUN ls -la .
ENTRYPOINT ["java","-jar","spring-boot-magic-0.0.1-SNAPSHOT.jar"]
