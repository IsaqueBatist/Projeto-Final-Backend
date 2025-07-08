# Step 1 - Build
FROM maven:3.9.4-eclipse-temurin-21-alpine AS build
WORKDIR /home/app/management-backend
COPY . .
RUN mvn -v && \
    mvn clean package -DskipTests

# Step 2 - Run
FROM eclipse-temurin:21-jre-alpine
COPY --from=build /home/app/management-backend/target/*.jar /usr/local/lib/management-backend.jar
VOLUME /tmp
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/management-backend.jar"]