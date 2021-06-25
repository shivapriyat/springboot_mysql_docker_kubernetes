FROM openjdk:8-jdk-alpine
ADD target/springboot-mysql-1.jar springboot-mysql-1.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "springboot-mysql-1.jar"]