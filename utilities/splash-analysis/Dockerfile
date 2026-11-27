###
#  this docker file creates a the complete image for deployment of the Splash analysis program
###

FROM eclipse-temurin:25-jre

RUN apt-get update -y && apt-get install -y --no-install-recommends bash coreutils curl unzip && rm -rf /var/lib/apt/lists/*

ADD target/splash-analysis-0.0.1-SNAPSHOT.jar /opt/analyze.jar
ADD complete-201510-precomputed.csv.gz /data/input.csv.gz
ADD src/run.sh /opt/run.sh

CMD ["/bin/bash", "/opt/run.sh"]