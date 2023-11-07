FROM openjdk:8
EXPOSE 8089
WORKDIR /Devops
COPY target/devops-integration.jar /Devops/
CMD ["java", "-jar","devops-integration.jar"]