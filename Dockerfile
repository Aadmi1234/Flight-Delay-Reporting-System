FROM ubuntu:latest

ENV DEBIAN_FRONTEND=noninteractive

RUN apt-get update && apt-get install -y \
    openjdk-11-jdk \
    maven \
    git \
    curl \
    mysql-server \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app

RUN git clone https://github.com/aadmi/your-repo.git .

# Build the Eureka application
WORKDIR /app/eureka
RUN mvn clean install -DskipTests

# Build the Admin application
WORKDIR /app/admin
RUN mvn clean install -DskipTests

# Build the Customer application
WORKDIR /app/customer
RUN mvn clean install -DskipTests

# Build the Staff application
WORKDIR /app/staff
RUN mvn clean install -DskipTests

# Expose the necessary ports
EXPOSE 8761 8081 8180 8280 3306

# Configure MySQL
RUN service mysql start && \
    mysql -e "CREATE DATABASE IF NOT EXISTS flight_delay_analysis_db;" && \
    mysql -e "CREATE USER IF NOT EXISTS 'root'@'%' IDENTIFIED BY '';" && \
    mysql -e "GRANT ALL PRIVILEGES ON flight_delay_analysis_db.* TO 'root'@'%';" && \
    mysql -e "FLUSH PRIVILEGES;"

# Start MySQL in the background, then start the Spring Boot applications in order
CMD service mysql start && \
    nohup java -jar target/eureka-application.jar & \
    sleep 10 && \
    nohup java -jar target/admin-application.jar & \
    sleep 10 && \
    nohup java -jar target/customer-application.jar & \
    sleep 10 && \
    java -jar target/staff-application.jar
