FROM arm64v8/maven AS build
WORKDIR /app
COPY pom.xml .
COPY src/ ./src/
RUN mvn clean package -DskipTests

FROM adoptopenjdk/openjdk14
WORKDIR /app
COPY --from=build /app/target/challenge-me-backend-*.jar ./app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
