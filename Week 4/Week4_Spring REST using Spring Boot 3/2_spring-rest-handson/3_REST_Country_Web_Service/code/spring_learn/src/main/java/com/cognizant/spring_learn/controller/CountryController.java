package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @RequestMapping(value = "/country", method = RequestMethod.GET) // Maps GET requests to /country
    public Country getCountryIndia() {
        LOGGER.info("START - getCountryIndia() method");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country india = context.getBean("in", Country.class);
        LOGGER.info("END - getCountryIndia() method");
        return india;
    }
}