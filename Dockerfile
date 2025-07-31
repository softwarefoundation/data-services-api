FROM gradle:8.14.3-jdk24-alpine as build

ENV APP_HOME=/opt/app

WORKDIR $APP_HOME

COPY . .

ARG BUILD_DATE=0.0.0
RUN sed -i "s/SPRING_APPLICATION_VERSION:1.0.0/SPRING_APPLICATION_VERSION:${BUILD_DATE}/g" src/main/resources/application.yaml
RUN gradle build -x test

FROM amazoncorretto:24-alpine-jdk as run

COPY --from=build /opt/app/build/libs/*war apps.war

EXPOSE 8080

CMD ["java", "-jar", "apps.war"]
