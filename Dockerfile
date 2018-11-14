FROM openjdk:8
ADD target/webserv.jar webserv.jar
EXPOSE 8080
ENV MONGODB_DB_HOST mongo
ENV MONGODB_DB_PORT 27017
ENTRYPOINT ["java", "-jar", "webserv.jar"]
