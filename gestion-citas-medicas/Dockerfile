# Usa una imagen base de OpenJDK 11
FROM openjdk:11-jre-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR de tu aplicación a la imagen Docker
COPY target/gestion-citas-medicas-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que la aplicación va a escuchar
EXPOSE 8080

# Comando para ejecutar la aplicación Spring Boot
CMD ["java", "-jar", "app.jar"]
