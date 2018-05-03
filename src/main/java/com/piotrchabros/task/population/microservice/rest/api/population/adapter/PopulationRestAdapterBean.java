package com.piotrchabros.task.population.microservice.rest.api.population.adapter;

import org.springframework.stereotype.Component;

import javax.ws.rs.core.UriBuilder;

import static com.piotrchabros.task.population.microservice.rest.api.population.adapter.common.Constants.*;

@Component
public class PopulationRestAdapterBean implements PopulationRestAdapter{

    public final static String BASE_URL =  "//api.population.io:80/1.0/population/";

    public UriBuilder getBaseUri(){
        return UriBuilder
                .fromPath(BASE_URL)
                .scheme(BASE_HOST);
    }

    public String getPopulationByCountryDateURL(String country, String date){
        return getBaseUri()
            .path(URL_SEPARATOR + BY_COUNTRY + URL_SEPARATOR + BY_DATE)
            .build(country, date)
            .toString();
    }

    public String getPopulationByYearAndAge(String year, String age){
        return null; //TODO: no need to implement! out of the scope of the project
    }

    public String getPopulationByYearCountryAge(String year, String country, String age){
        return null; //TODO: no need to implement! out of the scope of the project
    }

    public String getPopulationByYearAndCountry(String year, String country){
        return null; //TODO: no need to implement! out of the scope of the project
    }

    public String getPopulationByCountryAndByAge(String country, String age){
        return null; //TODO: no need to implement! out of the scope of the project
    }

    public String getPopulationByCountryAndByDate(String country, String date){
        return null; //TODO: no need to implement! out of the scope of the project
    }

    public String getPopulationByCountryTodayAndTomorrow(String country){
        return null; //TODO: no need to implement! out of the scope of the project
    }

}
