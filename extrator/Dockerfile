FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target
COPY ${JAR_FILE}/extrator*.jar /app/esocial.jar

CMD ["java","-jar", "/app/esocial.jar"]
VOLUME /tmp