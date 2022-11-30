#This is just a sample Docker build file for the application. Feel free to make changes in order to suit your needs.
FROM openjdk:alpine

MAINTAINER dev@hiis.io

RUN mkdir -p /root/zio-starter/

ADD target/scala-2.13/zio-starter.jar /root/zio-starter/zio-starter.jar


WORKDIR /root/zio-starter

RUN echo '#!/bin/ash' >> /root/zio-starter/run.sh
RUN echo 'java -jar /root/zio-starter/zio-starter.jar' >> /root/zio-starter/run.sh
RUN chmod a+x /root/zio-starter/run.sh

CMD [ "/root/zio-starter/run.sh" ]