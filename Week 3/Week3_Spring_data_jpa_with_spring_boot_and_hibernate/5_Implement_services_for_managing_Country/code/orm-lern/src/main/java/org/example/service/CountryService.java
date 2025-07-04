package org.example.service;

import org.example.entity.Country;
import org.example.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Optional<Country> findCountryByCode(String countryCode) {
        return countryRepository.findById(countryCode);
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