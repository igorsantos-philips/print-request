FROM openjdk:17-oracle
COPY ./build/print-request.jar /app/print-request.jar
ENTRYPOINT ["java"]
CMD ["-jar", "/app/print-request.jar"]
EXPOSE 8080