FROM openjdk:17
MAINTAINER "Sriram"
COPY target/my_first_app-0.0.1-SNAPSHOT.jar  /usr/app/
WORKDIR /usr/app/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "my_first_app-0.0.1-SNAPSHOT.jar"]
