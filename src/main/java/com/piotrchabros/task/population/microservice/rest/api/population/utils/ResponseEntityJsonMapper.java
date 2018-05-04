package com.piotrchabros.task.population.microservice.rest.api.population.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.Optional;

public class ResponseEntityJsonMapper {

    public static Optional<JsonNode> getOptionalJsonResponse(ResponseEntity<String> response){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return Optional.of(mapper.readTree(response.getBody()));
        } catch (IOException e)
        {
            return Optional.empty();
        }
    }

}
