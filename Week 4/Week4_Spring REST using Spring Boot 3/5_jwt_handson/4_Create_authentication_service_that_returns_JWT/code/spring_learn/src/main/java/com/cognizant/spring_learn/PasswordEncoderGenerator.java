package com.cognizant.spring_learn;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderGenerator {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "pwd";
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println("------------------------------------------------------------------");
        System.out.println("COPY THIS ENTIRE STRING FOR 'pwd': " + encodedPassword);
        System.out.println("------------------------------------------------------------------");
    }
}