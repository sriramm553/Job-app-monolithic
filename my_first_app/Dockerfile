FROM openjdk:11
MAINTAINER "Sriram"
ADD target/my_first_app.jar  /usr/app/
WORKDIR /usr/app/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "my_first_app.jar"]
