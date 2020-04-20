FROM openjdk:11.0.7-jre-slim

USER root
COPY ./keys/krb5.conf /app/krb5.conf
COPY ./keys/bdp_admin_s.keytab /app/bdp_admin_s.keytab
COPY ./keys/bdp_otrdwh_s.keytab /app/bdp_otrdwh_s.keytab
COPY ./build/libs/HiveJdbc-1-all.jar /app/HiveJdbc-1-all.jar
WORKDIR /app
EXPOSE 8090
USER 1000
CMD ["java", "-cp", "/app/HiveJdbc-1-all.jar", "com.hive.Start"]