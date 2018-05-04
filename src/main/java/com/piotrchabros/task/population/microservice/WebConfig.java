package com.piotrchabros.task.population.microservice;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler(
                        "/webjars/**",
                        "/js/**",
                        "/css/**")
                .addResourceLocations(
                        "/webjars/",
                        "classpath:/static/js/",
                        "classpath:/static/css/");
    }
}
