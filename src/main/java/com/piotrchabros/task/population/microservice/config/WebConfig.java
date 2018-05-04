package com.piotrchabros.task.population.microservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * provides resource configuration for the template engine and resolver (in this case thymeleaf)
     * @param registry
     */
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
