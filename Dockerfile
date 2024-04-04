FROM openjdk:17-jdk-alpine
COPY ./target/hatshop-0.0.1-SNAPSHOT.jar hatshop-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "hatshop-0.0.1-SNAPSHOT.jar"]