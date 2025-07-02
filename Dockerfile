FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app
COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM amazoncorretto:21-alpine-jdk
LABEL org.opencontainers.image.source="https://github.com/DataDog/vulnerable-java-application/"
RUN apk add --no-cache wget tar curl
RUN mkdir -p /tmp/files && echo "hello" > /tmp/files/hello.txt && echo "world" > /tmp/files/foo.txt

# Install Tomcat
RUN wget https://downloads.apache.org/tomcat/tomcat-10/v10.1.41/bin/apache-tomcat-10.1.41.tar.gz && \
    tar xvf apache-tomcat-10.1.41.tar.gz -C /opt/ && \
    rm apache-tomcat-10.1.41.tar.gz

EXPOSE 8080

# Deploy WAR to Tomcat
COPY --from=build /app/target/sample-vulnerable-java-app-0.0.1-SNAPSHOT.war /opt/apache-tomcat-10.1.41/webapps/WebApp.war

CMD ["/opt/apache-tomcat-10.1.41/bin/catalina.sh", "run"]
