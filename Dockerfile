FROM openjdk:8
ADD target/webserv.jar webserv.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "webserv.jar"]
