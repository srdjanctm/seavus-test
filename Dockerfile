FROM ubuntu:latest
MAINTAINER corefinder@docker.com
# Update ubuntu system
RUN apt-get update
# Install java version on ubuntu-selenium image
RUN apt-get install -y default-jdk
RUN apt-get install -y default-jre
# Install phantomjs
#RUN apt-get install -y phantomjs
# Install maven on ubuntu-selenium image
RUN apt-get install -y maven
# Install git on ubuntu-selenium image
#RUN apt-get install -y git
WORKDIR "/"
# Run the maven command to execute all the tests
RUN apt-get install wget -y
RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN dpkg -i google-chrome-stable_current_amd64.deb; apt-get -fy install
RUN mkdir /tests
WORKDIR "/tests"
ADD ./entrypoint.sh /tests/entrypoint.sh
ENTRYPOINT ["/tests/entrypoint.sh"]