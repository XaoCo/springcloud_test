FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/provider-0.0.1-SNAPSHOT.jar provider.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/provider.jar"]
