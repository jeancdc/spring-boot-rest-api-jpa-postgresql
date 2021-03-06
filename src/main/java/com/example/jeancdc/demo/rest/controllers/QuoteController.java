package com.example.jeancdc.demo.rest.controllers;

import com.example.jeancdc.demo.rest.models.Quote;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class QuoteController {

    @RequestMapping(value = "/quote")
    public Quote getQuote() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
    }

}
