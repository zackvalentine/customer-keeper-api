FROM amidos/dcind:2.0.0

RUN apk update && \
    apk add --no-cache openjdk11 openssl git curl python which

RUN curl -sSL https://sdk.cloud.google.com | bash

ENV PATH $PATH:/root/google-cloud-sdk/bin
