FROM openjdk:11
COPY ./bin/transformer.jar /usr/app/
COPY ./test-data/** /usr/app/test-data/
WORKDIR /usr/app