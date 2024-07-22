
FROM openjdk:17-jdk-alpine AS build

WORKDIR /app

COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn
RUN ./mvnw dependency:go-offline -B

COPY . .

# Build aplikasi
RUN ./mvnw clean install -DskipTests

# Gunakan image JDK untuk runtime tahap kedua
FROM openjdk:17-jdk-alpine

# Setel direktori kerja di dalam container
WORKDIR /app

# Salin jar file dari tahap build sebelumnya
COPY --from=build /app/target/*.jar app.jar

# Jalankan aplikasi
ENTRYPOINT ["java", "-jar", "app.jar"]
