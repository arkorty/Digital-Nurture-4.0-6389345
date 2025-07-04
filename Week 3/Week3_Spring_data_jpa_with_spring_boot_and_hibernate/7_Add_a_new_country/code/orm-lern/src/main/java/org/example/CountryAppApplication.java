package org.example;

import org.example.entity.Country;
import org.example.service.CountryService;
import org.example.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CountryAppApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryAppApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CountryAppApplication.class, args);
        countryService = context.getBean(CountryService.class);

        LOGGER.info("Inside main");

        testFindCountryByCode();
    }

    private static void testFindCountryByCode() {
        LOGGER.info("Start testFindCountryByCode");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.info("Country with code IN: {}", country.getName());

            Country nonExistentCountry = countryService.findCountryByCode("XX");
            LOGGER.info("Country with code XX: {}", nonExistentCountry.getName());

        } catch (CountryNotFoundException e) {
            LOGGER.error("Exception occurred: {}", e.getMessage());
        }
        LOGGER.info("End testFindCountryByCode");
    }
}