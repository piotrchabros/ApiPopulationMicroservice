package com.piotrchabros.task.population.microservice.rest.service.population.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.Optional;

public class LifeExpectancyMapper {

    public final static String TOTAL_LIFE_EXPECTANCY = "total_life_expectancy";

    public static Optional<Float> getTotalLifeExpectancy(ResponseEntity<String> response){
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(response.getBody());
            JsonNode jsonNode = root.get(TOTAL_LIFE_EXPECTANCY);
            return Optional.of(jsonNode.floatValue());
        } catch (IOException e)
        {
            return Optional.empty();
        }
    }

}
