FROM eclipse-temurin:17
WORKDIR /home
COPY ./target/coffee-order-0.0.1.jar coffee-order.jar
ENTRYPOINT ["java", "-jar", "coffee-order.jar"]
LABEL authors="tno52"
