FROM openjdk:14-alpine
COPY build/libs/param-test-*-all.jar param-test.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "param-test.jar"]