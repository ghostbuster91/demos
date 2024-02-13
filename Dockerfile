FROM ubuntu:latest
RUN apt update -y
RUN apt install -y openjdk-17-jdk
RUN apt install -y maven
RUN apt install -y curl
RUN curl -fL https://github.com/Virtuslab/scala-cli/releases/latest/download/scala-cli-x86_64-pc-linux.gz | gzip -d > scala-cli
RUN chmod +x scala-cli
RUN mv scala-cli /usr/local/bin/scala-cli
# COPY ./stations /src
WORKDIR /src
# RUN mvn -s settings.xml compile
