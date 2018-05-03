package com.piotrchabros.task.population.microservice.rest.service.population.adapter;

import com.piotrchabros.task.population.microservice.rest.api.population.facade.ApiPopulationRestAdapterFacade;
import com.piotrchabros.task.population.microservice.rest.service.population.utils.LifeExpectancyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class PopulationRestServiceAdapterBean implements PopulationRestServiceAdapter {

    @Autowired
    ApiPopulationRestAdapterFacade apiPopulationRestAdapterFacadeBean;

    public Optional<Float> getTotalLifeExpectancyBySexCountryDate(String sex, String country, String date) {
        RestTemplate restTemplate = new RestTemplate();
        String url = apiPopulationRestAdapterFacadeBean.getTotalLifeExpectancyURL(sex, country, date);
        Map<String, String> uriParams = new HashMap<>();
        uriParams.put("format", "json");
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, uriParams);
        return LifeExpectancyMapper.getTotalLifeExpectancy(response);
    }
}
