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
 * Jackson
 * JUnit

#### GUI

- Css (bootstrap)
- jQuery (ajax mostly)
- plain Javascript
- PlotlyJs for the data visualization

## Installation / Running instructions

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
