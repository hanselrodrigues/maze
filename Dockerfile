FROM adoptopenjdk/openjdk11:aarch64-centos-jdk-11.0.14.1_1-slim
EXPOSE 8080
COPY target/*.jar /opt/app.jar
WORKDIR /opt
CMD ["java", "-jar", "app.jar"]