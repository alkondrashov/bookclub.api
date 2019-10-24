FROM carsharing/alpine-oraclejdk8-bash
ADD target/fh-transaction-0.0.1-SNAPSHOT.war app.jar
COPY . /usr/src/app/
#RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
EXPOSE 8080