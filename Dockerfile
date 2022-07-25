FROM openjdk:8
ADD target/atmcustomer-0.0.1-SNAPSHOT.jar atmcustomer-0.0.1-SNAPSHOT.jar
EXPOSE 9082
ENTRYPOINT ["java", "-jar", "atmcustomer-0.0.1-SNAPSHOT.jar"]