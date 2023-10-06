FROM openjdk:17-alpine

ADD build/libs/NurBnbC-1.0-SNAPSHOT*.jar NurBnbC-1.0-SNAPSHOT.jar

COPY --from=build /build/libs/NurBnbC-1.0-SNAPSHOT*.jar app.jar

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "/app.jar", "--server.port=8083"]