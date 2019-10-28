package com.example.jeancdc.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Configuration
public class WebConfiguration {

    private String[] allowedOrigins = {"http://localhost:9000", "http://localhost:9001"};

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // registry.addMapping("/greeting").allowedOrigins(allowedOrigins);
                // registry.addMapping("/customers").allowedOrigins("http://localhost:9000");
                registry.addMapping("/**")
                        .allowedOrigins(allowedOrigins)
                        .allowedMethods("GET");
            }
        };
    }

    /* @Bean
    public WebApplicationInitializer webApplicationInitializer() {
        return new WebApplicationInitializer() {
            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {
                DispatcherServlet servlet = new DispatcherServlet();
                ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
                registration.setLoadOnStartup(1);
                registration.addMapping("/app/*");
            }
        };
    } */

}
