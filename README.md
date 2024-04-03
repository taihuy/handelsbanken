# Handelsbanken - e-commerce API Application

This is a simplified e-commerce API with a single endpoint that performs a checkout action

## Prerequisites

Before running the application, make sure you have the following installed:

- Java Development Kit (JDK) 21 or later
```shell
https://www.oracle.com/java/technologies/downloads/
```
- Maven
```shell
https://maven.apache.org/download.cgi
```

You can check if those are installed and see their versions by opening a command prompt or terminal and running the following commands:

For Java:

```shell
java -version
```
If Java is installed, you should see output similar to this (version number may vary):
```shell
java version "21.0.2" 2021-01-19
Java(TM) SE Runtime Environment (build 21.0.2+12-57)
Java HotSpot(TM) 64-Bit Server VM (build 21.0.2+12-57, mixed mode, sharing)
```

For Maven:
```shell
mvn -v
```

If Maven is installed, you should see output similar to this (version number may vary):
```shell
Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)
Maven home: /usr/share/maven
Java version: 1.8.0_275, vendor: Private Build, runtime: /usr/lib/jvm/java-8-openjdk-amd64/jre
Default locale: en, platform encoding: UTF-8
OS name: "linux", version: "5.4.0-65-generic", arch: "amd64", family: "unix"
```

## Getting Started

1. Clone the repository:

    ```shell
    git clone <repository-url>
    ```

2. Navigate to the project directory:

    ```shell
    cd <project-directory>
    ```

3. Build the application using Maven:

    ```shell
    mvn clean install
    ```

4. Test the application using Maven:
    ```shell
    mvn test
    ```
5. Run the application:
    
    Using Java
    ```shell
    java -jar target/ecommerceapi-<version>.jar
    ```

    Using Maven
    ```shell
    mvn spring-boot:run
    ```

    Replace `<version>` with the actual version of ecommerceapi application.

6. Use Postman or other software application that allows you to communicate with an API:

    ```
    localhost:8080/checkout
    ```

## Configuration

If you need to configure any application properties, you can do so in the `application.properties` or `application.yml` file located in the `src/main/resources` directory.


## License

This project is licensed under ...