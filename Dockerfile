FROM amazoncorretto:21


LABEL authors="olavo"

WORKDIR /app

COPY target/login-auth-api-0.0.1-SNAPSHOT.jar app.jar


EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
