# Api.Population REST Microservice 

## About this application

This is a small microservice that performs the following steps: 
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
 * Jersey
 * JUnit
 
The implementation followed common coding practices and the code is documented as well as possible. Some parts of the code which are not documented should be self-explanatory.

#### GUI

- the purpose of this application was mainly to show the backend logic and functionality
- I am not a front-end dev so for the GUI part a simple jQuery scripts were used, some parts may look ugly
- Bootstrap
- jQuery (ajax mostly)
- plain Javascript
- PlotlyJs for the data visualization

## Installation / Running instructions

* You can run this application by cloning the repository and importing this project into the Java IDE of your choice.
* After importing make sure that the project SDK is set up to at least Java 8.
* Start the application by running com.piotrchabros.task.population.microservice.MicroserviceApplication.java.
* Open web browser and navigate to http://localhost:8080
* I recommend using IntelliJ for running the application it was set up in it.
* You should see something like this in the console output: 

`2018-05-04 20:43:02.160  INFO 9004 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2018-05-04 20:43:02.164  INFO 9004 --- [           main] c.p.t.p.m.MicroserviceApplication        : Started MicroserviceApplication in 4.557 seconds (JVM running for 5.201)`
* This means that he application started successfully and is accessible.

You can also run this microservice by building this application into a jar file using spring-boot-maven-plugin and run it in external container e.g. Tomcat

## Possible further improvements

### Backend
* [ ] use some caching mechanism
* [ ] store and periodically update the data using scheduler, e.g. [quartz](http://www.quartz-scheduler.org/)

### Frontend
* [ ] use webpack, eslint and other useful plugins and tools
* [ ] display datepickers for a freedom to pick various dates
* [ ] frontend as a separate microservice
* [ ] use different technology for the frontend. e.g Angular/React/ExtJS

## Troubleshooting

* Before running clean, test and install this application using maven
* It happened to me once that a test failed due to ConnectionTimeoutException. This was caused by connection issues on the side of the external API. Please wait a few more seconds and re-run the test. 
* If you encounter an error `org.apache.catalina.LifecycleException: Failed to start component [Connector[HTTP/1.1-8080]]` this means there is something else already listening on the port 8080. Please change or release this port.
* In case of any other errors please contact me at piotrchabros@outlook.com
