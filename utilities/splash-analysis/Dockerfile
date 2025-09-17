###
#  this docker file creates a the complete image for deployment of the Splash analysis program
###

FROM openjdk:21-jre

RUN DEBIAN_FRONTEND=noninteractive apt-get -yq update && apt-get -yq upgrade

####
# do the actual installation
####
RUN \
    apt-get update && \
    apt-get install -y gzip && \
    rm -rf /var/lib/apt/lists/* && \
    mkdir /data


ADD target/splash-analysis-0.0.1-SNAPSHOT.jar /opt/analyze.jar
#ADD src/data/input.csv /data/input.csv
ADD complete-201510-precomputed.csv.gz /data/input.csv.gz
ADD src/run.sh /opt/run.sh


CMD ["/bin/bash","/opt/run.sh"]