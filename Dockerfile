FROM openjdk:21
COPY target/*.jar app.jar
CMD ["java","-jar","app.jar"]
