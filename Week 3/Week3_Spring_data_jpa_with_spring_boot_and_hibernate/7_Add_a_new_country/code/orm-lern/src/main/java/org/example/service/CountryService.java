package org.example.service;

import org.example.entity.Country;
import org.example.repository.CountryRepository;
import org.example.service.exception.CountryNotFoundException; // Import the new exception
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Import @Transactional

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(countryCode);

        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found with code: " + countryCode);
        }

        return result.get();
    }

    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country updateCountry(String countryCode, Country updatedCountry) {
        return countryRepository.findById(countryCode)
                .map(country -> {
                    country.setName(updatedCountry.getName());
                    return countryRepository.save(country);
                })
                .orElse(null);
    }

    public void deleteCountry(String countryCode) {
        countryRepository.deleteById(countryCode);
    }

    public List<Country> findCountriesByPartialName(String partialName) {
        return countryRepository.findByNameContainingIgnoreCase(partialName);
    }
}