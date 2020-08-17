FROM openjdk:11

EXPOSE 8080

ADD ./target/rssfeed-0.0.1-SNAPSHOT.jar myapp.jar
RUN sh -c 'touch /myapp.jar'
ENTRYPOINT ["java","-jar","/myapp.jar"]