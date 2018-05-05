# Api.Population REST Microservice 

![image](https://user-images.githubusercontent.com/29580834/39666092-51f4d33a-509e-11e8-8a2b-c44b12aa998a.png)
![image](https://user-images.githubusercontent.com/29580834/39666095-5b057f92-509e-11e8-9c36-2eb01ad394ba.png)

## About this application

This is a lightweight microservice that performs the following steps: 
* fetches data from a public API,
* transforms the data and presents it in a user-friendly form,
* presents the data in a single page application.

Used API: [api.population.io](http://api.population.io)

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
 * Jackson
 * JUnit

#### GUI

- Css (bootstrap)
- jQuery (ajax mostly)
- plain Javascript
- PlotlyJs for the data visualization

## Additional information

The com.piotrchabros.task.microservice package is the root of the packages:
* config - contains global configuration for the application
* rest.api.population - contains classes related with the api.population rest api
* rest.api.population.adapter - contains classes and interface adapters between microservice and population api
* rest.api.population.common - contains classes with common functionalities used in the population package
* rest.api.population.utils - contains utility classes to reduce boilderplate code in the population package
* rest.api.population.facade - contains facade class which acts like an access/gateway to various adapters
* rest.api.microservice - contains rest interfaces and classes of the front-end
* rest.api.microservice.controller - controllers of the microservice
* rest.api.microservice.controller.advice - configuration of the controllers using advice, exception handling 

Logging is divided between standard output and a log file (microservice_debug.log), where only errors are printed to the console, and info-level messages go to the file. 

## Installation/running instructions

* You can run this application by cloning the repository and importing this project into the Java IDE of your choice.
* After importing make sure that the project SDK is set up to at least Java 8.
* Start the application by running com.piotrchabros.task.population.microservice.MicroserviceApplication.java.
* Open web browser and navigate to http://localhost:8080

You can also run this microservice by building this application into a jar file using spring-boot-maven-plugin and run it in external container e.g. Tomcat

## Possible additional improvements

### Cache
* caching mechanism would useful in improving performance of retrieving the data, if population API would cause any issues
* cache could be implemented on the front-end, as well as on the back-end
* could also store and periodically update the data in the backend using scheduler, e.g. [quartz](http://www.quartz-scheduler.org/)

### Frontend
* use webpack, eslint and other useful plugins and tools
* display datepickers for a freedom to pick various dates
* frontend as a separate microservice
* use different technology for the frontend. e.g Angular/React/ExtJS

## Troubleshooting

* Before running clean, test and install this application using maven
* If you encounter an error `org.apache.catalina.LifecycleException: Failed to start component [Connector[HTTP/1.1-8080]]` this means there is something else already listening on the port 8080. Please change or release this port.
* In case of any other errors please contact me at piotrchabros@outlook.com
