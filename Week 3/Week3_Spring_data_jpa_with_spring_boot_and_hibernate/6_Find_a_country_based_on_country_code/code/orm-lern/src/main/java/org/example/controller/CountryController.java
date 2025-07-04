package org.example.controller;

import org.example.entity.Country;
import org.example.service.CountryService;
import org.example.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/{code}")
    public ResponseEntity<Country> getCountryByCode(@PathVariable String code) {
        try {
            Country country = countryService.findCountryByCode(code);
            return ResponseEntity.ok(country);
        } catch (CountryNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Country addCountry(@RequestBody Country country) {
        return countryService.addCountry(country);
    }

    @PutMapping("/{code}")
    public ResponseEntity<Country> updateCountry(@PathVariable String code, @RequestBody Country country) {
        Country updatedCountry = countryService.updateCountry(code, country);
        if (updatedCountry != null) {
            return ResponseEntity.ok(updatedCountry);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteCountry(@PathVariable String code) {
        countryService.deleteCountry(code);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<Country> searchCountriesByName(@RequestParam String name) {
        return countryService.findCountriesByPartialName(name);
    }
}