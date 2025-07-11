package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.exception.CountryNotFoundException;
import com.cognizant.spring_learn.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);


    @Autowired
    @Qualifier("countryList")
    private List<Country> countryList;

    public CountryService() {
        LOGGER.debug("CountryService constructor called");
    }

    public Country getCountry(String code) throws CountryNotFoundException {
        LOGGER.info("START - getCountry() for code: {}", code);
        Country foundCountry = countryList.stream()
                .filter(country -> country.getCode().equalsIgnoreCase(code))
                .findFirst() // Get the first matching country
                .orElseThrow(() -> new CountryNotFoundException("Country with code '" + code + "' not found")); // Throw exception if not found

        LOGGER.info("END - getCountry() found: {}", foundCountry);
        return foundCountry;
    }
}