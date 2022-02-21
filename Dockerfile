FROM adoptopenjdk:11.0.10_9-jre-openj9-0.24.0
RUN mkdir /app
COPY out/production/DockerTest /app
COPY input /app/input
WORKDIR /app
CMD java de.whs.ibci.Main