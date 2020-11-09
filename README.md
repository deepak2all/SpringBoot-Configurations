## Project: 
SpringBoot-Configurations


## Description: 
Best proctices to keep the configurations in Microservice World


## Goals

*1. Have the config externalized*

*2. Have the config environment specific*

*3. Have the config consistent (so that all microservices look at one particular version of file)*

*4. Version history*

*5. Real time management (without bringing down the microservices)*



## Installation and execution

### To build and package a Spring Boot app into a single executable Jar file with a Maven, use the below command ###
**maven package (or)  mvn install**


*To run your Spring Boot app from a command line in a Terminal window you can use the java -jar command.* 
```
java -jar target/UserService 0.0.1-SNAPSHOT.jar
```

*To run Spring Boot app using Maven, use the below command*
```
mvn spring-boot:run 
```

## Documentation for achieving the goals ##

*1. Have the config externalized* - Using application.properties which can be configured within and outside of jar file (different levels)
```
a) Using @Value annotations to fetch static value
```
```
b) Using @Value annotations accompanied with $, to fetch values from properties file, dynamically
```
```
c) Using @Value annotations accompanied with $ and #, to fetch values from properties file, dynamically as maps (SPEL)
```
```
d) To group and fetch multiple properties at once, dynamically using ConfigurationProperties
```

*2. Have the config environment specific - Using Profiles*
```
New profiles can be creates using the naming convention - application-<profileName>.extn (where extn can be "properties" or "yml")
Profiles can be activated from properties using the below config
spring.profiles.active=<profileName>
It can be activated externally from command line 
java -jar spring-boot-config-0.0.1-SNAPSHOT.jar --spring.profiles.active=<profileName>
```

*3. Have the config consistent (so that all microservices look at one particular version of file)*

```
Popular options
a) Apache Zookeeper
b) ETCD - Distributed key values store
c) Spring Cloud Configuration Server
```

*4. Version history*
```
Managed using GIT for Spring Cloud Configuration Server
```

*5. Real time management (without bringing down the microservices)*
```
a) For the Spring Cloud Configuration Server, it always looks at the GIT repo and henceforth any changes made into GIT repo is reflected in the server, without re-start
b) For the clients, one of the end-point that actuator exposes is the hook. Using hook, we can tell the client to refresh it's config. The beans annotated with "@RefreshScope" alone gets refreshed upon notification. And actuator end-point from where the post needs to happen is 
http://<server-name>:<port>/actuator/refresh
```

*6. Viewing the Configured properties*
```
Assigning Environment instance to a variable and retrieving the methods exposed by Environment
```
```
Using actuators, to fetch values from properties file
The values of our properties as well as in-built properties will be visible from the url
http://<hostname:port>/actuator/configprops
```
