package com.piotrchabros.task.population.microservice.rest.api.population.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.piotrchabros.task.population.microservice.persistence.entity.LifeExpectancy;
import com.piotrchabros.task.population.microservice.persistence.entity.Population;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.util.Optional;

/**
 * This class is implementing methods for parsing the response from and into the desired format
 * It can be easily extended to parse from and to different formats e.g. POJOs
 */
public class ResponseEntityJsonMapper {

    static Logger LOG = LoggerFactory.getLogger(ResponseEntityJsonMapper.class);

    /**
     * parses the response entity of type String into a com.fasterxml.jackson.databind.JsonNode object
     * @param uri - the uri to fetch the data from
     * @return JsonNode object representation of the response
     */
    public static Optional<JsonNode> getOptionalJsonResponse(URI uri, Class cls){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(uri, cls);
        ObjectMapper mapper = new ObjectMapper();
        //try parse the response from string into json
        try {
            return Optional.of(mapper.readTree(response.getBody()));
        } catch (IOException e)
        {
            //in case response is in the wrong format, log and error, return an empty optional
            LOG.error("The requested resource was in the wrong format: " + response);
            return Optional.empty();
        }
    }

}
