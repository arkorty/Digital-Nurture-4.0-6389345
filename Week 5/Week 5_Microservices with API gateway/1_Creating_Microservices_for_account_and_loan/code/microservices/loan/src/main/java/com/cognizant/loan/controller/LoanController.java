package com.cognizant.loan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoanController {

    @GetMapping("/loans/{number}")
    public Map<String, Object> getLoanDetails(@PathVariable String number) {
        Map<String, Object> loanDetails = new HashMap<>();
        loanDetails.put("number", number);
        loanDetails.put("type", "car");
        loanDetails.put("loan", 400000);
        loanDetails.put("emi", 3258);
        loanDetails.put("tenure", 18);
        return loanDetails;
    }
}