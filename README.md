## Project: 
SpringBoot-Configurations


## Description: 
Best proactices to keep the configurations in Microservice World


## Goals

*1. Have the config externalized*

*2. Have the config environment specific*

*3. Have the config consistent (so that all microservices look at one particular version of file)*

*4. Version history*

*5. Real time management (without bringing down the microservices)*



## Installation and execution

### To build and package a Spring Boot app into a single executable Jar file with a Maven, use the below command###
**maven package (or)  mvn install**


*To run your Spring Boot app from a command line in a Terminal window you can use the java -jar command.* 
```
java -jar target/UserService 0.0.1-SNAPSHOT.jar
```

*To run Spring Boot app using Maven, use the below command*
```
mvn spring-boot:run 
```

## Documentation

*1. Have the config externalized*
```
Using @Value annotations to fetch static value
```
```
Using @Value annotations accompanied with $, to fetch values from properties file, dynamically
```
```
Using @Value annotations accompanied with $ and #, to fetch values from properties file, dynamically as maps
```
```
To group and fetch multiple properties at once, dynamically using ConfigurationProperties
```
*2. Have the config environment specific*

*3. Have the config consistent (so that all microservices look at one particular version of file)*

*4. Version history*

*5. Real time management (without bringing down the microservices)*
