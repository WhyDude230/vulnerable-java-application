FROM tomcat:10.1.41-jdk21-temurin

COPY sample-vulnerable-java-app-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/sample-web-app.war

EXPOSE 8080

CMD ["catalina.sh", "run"]