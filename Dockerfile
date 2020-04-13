FROM openjdk:8-jdk-alpine
MAINTAINER www.gitlab.com/nlaert
VOLUME /tmp
EXPOSE 8080
RUN bash gradle build
ADD build/libs/fota-0.0.1-SNAPSHOT.jar fota.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/fota.jar"]