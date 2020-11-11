FROM amidos/dcind:2.0.0

RUN apk update && \
    apk add --no-cache openjdk11 openssl git curl python which

RUN curl -sSL https://sdk.cloud.google.com | bash

RUN chmod +x ./scripts/latest-git-revision.sh

ENV PATH $PATH:/root/google-cloud-sdk/bin
