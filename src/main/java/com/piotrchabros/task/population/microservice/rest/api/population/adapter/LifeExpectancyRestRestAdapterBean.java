package com.piotrchabros.task.population.microservice.rest.api.population.adapter;

import org.springframework.stereotype.Component;

import javax.ws.rs.core.UriBuilder;

import static com.piotrchabros.task.population.microservice.rest.api.population.adapter.common.Constants.*;

@Component
public class LifeExpectancyRestRestAdapterBean implements LifeExpectancyRestAdapter {

    public final static String BASE_URL =  "//api.population.io:80/1.0/life-expectancy/";
    public final static String BY_SEX = "{sex}";
    public final static String BY_TOTAL = "total";

    public UriBuilder getBaseUri(){
        return UriBuilder
                .fromPath(BASE_URL)
                .scheme(BASE_HOST);
    }

    public String getTotalLifeExpectancyURL(String sex, String country, String dateOfBirth){
        return getBaseUri()
            .path(URL_SEPARATOR + BY_TOTAL + URL_SEPARATOR + BY_SEX + URL_SEPARATOR + BY_COUNTRY + URL_SEPARATOR + BY_DATE_OF_BIRTH + URL_SEPARATOR)
            .build(sex, country, dateOfBirth)
            .toString();
    }

    public String getRemainingLifeExpectancyURL(String sex, String country, String date, String age){
        return null; //TODO: no need to implement! out of the scope of the project
    }

    public String gerRemainingLifeExpectancyWithDiabetesURL(String hasDiabetes, String sex, String country, String age){
        return null; //TODO: no need to implement! out of the scope of the project
    }


}
