FROM openjdk:14-alpine
COPY build/libs/ses-db-*-all.jar ses-db.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "ses-db.jar"]