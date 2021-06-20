FROM ubuntu:16.04

ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64
ENV CATALINA_HOME /opt/tomcat/apache-tomcat-8.5.64
ENV PATH $CATALINA_HOME/bin:$PATH

RUN apt-get update -y
RUN apt-get install net-tools -y


RUN apt-get update && DEBIAN_FRONTEND=noninteractive apt-get install -y openjdk-8-jdk

WORKDIR /opt/tomcat/
ADD apache-tomcat-8.5.64.tar.gz /opt/tomcat/

RUN apt-get update && DEBIAN_FRONTEND=noninteractive apt-get install -y mysql-server

COPY mysqldb_conf.sh ./
RUN sh mysqldb_conf.sh

#COPY ecomm-1.0.war /opt/tomcat/apache-tomcat-8.5.64/webapps

ADD entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

EXPOSE 8080 3306

ENTRYPOINT /entrypoint.sh
