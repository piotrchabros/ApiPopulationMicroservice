# Api.Population REST Microservice 

## About this application

This is a small microservice that performs the following steps: 
* fetches data from a public API,
* transforms the data and presents it in a user-friendly form,
* presents the data in a single page application.

Used API: http://api.population.io

#### Fetched data:

- population and life expectancy for three countries

#### Transforms/calculations: 

- total population today per country
- average life expectancy for persons born on 1952-01-01 per country

#### Used the following technologies:
* Java 8
* Latest stable version of Spring Boot (currently 2.0.1)
* REST for the frontend API
* Maven

###### Additional Java frameworks and libraries used to implement the microservice:
 * Thymeleaf
 * JodaTime
 * Lombok
 * Jersey
 * JUnit
 * H2
 
The implementation followed common coding practices and the code is documented as well as possible.

## Installation / Running instructions

* You can run this application by cloning the repository and importing this project into the Java IDE of your choice.
* After importing make sure that the project SDK is set up to at least Java 8.
* Start the application by running com.piotrchabros.task.population.microservice.MicroserviceApplication.java.
* Open web browser and navigate to http://localhost:8080
* I recommend using IntelliJ for running the application it was set up in it.

You can also run this microservice by building this application into a jar file using spring-boot-maven-plugin and run 
