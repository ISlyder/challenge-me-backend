FROM arm64v8/maven AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src/ ./src/
RUN mvn package
FROM adoptopenjdk/openjdk14
WORKDIR /app
COPY --from=build /app/target/challenge-me-backend-*.jar ./app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]