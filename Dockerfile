# Usa a imagem do Maven para Compilar a aplicação 
FROM maven:3.8.6-eclipse-temurin-17 as builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests


# Usa uma imagem do JDK para rodar o .jar gerado
# Java 17
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]