FROM openjdk:21
COPY ./target/userservice.jar	userservice.jar
CMD ["java","-jar","userservice.jar"]