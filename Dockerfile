FROM openjdk:11

WORKDIR /app
COPY target/timer-3.0.0-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "timer-3.0.0-SNAPSHOT.jar"]