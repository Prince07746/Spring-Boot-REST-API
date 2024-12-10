FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/hospital-management-1.0.1.jar /app/app.jar
EXPOSE 3030
ENTRYPOINT ["java","-jar","app.jar"]