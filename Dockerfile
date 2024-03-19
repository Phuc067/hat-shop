FROM openjdk:21-ea-21-windowsservercore-1809
ARG JAR_FILE = target/*.jar
COPY ./target/hatshop-0.0.1-SNAPSHOT.jar hatshop-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "hatshop-0.0.1-SNAPSHOT.jar"]