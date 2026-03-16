# Usa una imagen base con Maven y Java 21 (según pom.xml)
FROM maven:3.9-eclipse-temurin-21-alpine

# Establece el directorio de trabajo
WORKDIR /app

# Copia el pom.xml y descarga dependencias (para cachear capas)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia el código fuente
COPY src ./src

# Construye la app
RUN mvn clean package -DskipTests

# Expone el puerto
EXPOSE 8080

# Comando para ejecutar (glob no expande en exec form, así que usamos sh -c)
CMD ["sh", "-c", "java -jar target/*.jar"]