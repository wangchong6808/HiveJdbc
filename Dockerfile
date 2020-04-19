FROM openjdk:11.0.7-jre-slim

USER root
COPY ./krb5.conf /home/bdp_admin_s/HiveTest/krb5.conf
COPY ./bdp_admin_s.keytab /app/bdp_admin_s.keytab
COPY ./bdp_otrdwh_s.keytab /app/bdp_otrdwh_s.keytab
COPY ./HiveJdbc/build/libs/HiveJdbc-1-all.jar /app/HiveJdbc-1-all.jar
WORKDIR /app
EXPOSE 8090
USER root
CMD ["java", "-cp", "/app/HiveJdbc-1-all.jar", "com.hive.Start"]