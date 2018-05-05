package com.piotrchabros.task.population.microservice.rest.controller.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *  A single, global error handling component
 *
 *  The actual mechanism is extremely simple but also very flexible:
 *  it allows full control over the body of the response as well as the status code
 *  it allows mapping of several exceptions to the same method, to be handled together
 *  it makes good use of the newer RESTful ResposeEntity response
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { HttpClientErrorException.class, HttpServerErrorException.class })
    protected ResponseEntity<Object> handleError(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Invalid data supplied!";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}