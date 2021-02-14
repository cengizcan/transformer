FROM openjdk:11
COPY ./target/transformer.jar /usr/app/
COPY ./test-data/** /usr/app/test-data
WORKDIR /usr/app