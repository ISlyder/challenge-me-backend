## CDB Build image
FROM maven:3.6.3-jdk-14 AS challenge-app
ENV CHALL /bin/challenge
WORKDIR ${CHALL}
COPY ./backend/challenge/pom.xml .
RUN mvn dependency:go-offline
COPY ./backend/challenge/src ./src
RUN mvn package -DskipTests

## CDB run image
FROM openjdk:14.0.2-jdk
ENV CHALL /bin/challenge
ENV DB_HOST=chall-db
ENV DB_PORT=5432
WORKDIR ${CHALL}
COPY ./docker/wait-for-it.sh .
RUN chmod +x ./wait-for-it.sh
COPY --from=challenge-app ${CHALL}/target ./target
ENTRYPOINT bash ./wait-for-it.sh -t 30 ${DB_HOST}:$DB_PORT -- java -jar target/*.jar
