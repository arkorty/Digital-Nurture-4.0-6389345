package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/authenticate")
    public ResponseEntity<Map<String, String>> createAuthenticationToken(@RequestHeader("Authorization") String authorizationHeader) {

        String username;
        String password;

        try {
            String base64Credentials = authorizationHeader.substring("Basic ".length()).trim();
            byte[] decodedCredentials = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(decodedCredentials, StandardCharsets.UTF_8);

            String[] parts = credentials.split(":", 2);
            if (parts.length != 2) {
                return ResponseEntity.status(401).body(Map.of("error", "Invalid Basic Authorization header format"));
            }
            username = parts[0];
            password = parts[1];

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400).body(Map.of("error", "Invalid Base64 encoding in Authorization header"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("error", "Error processing Authorization header: " + e.getMessage()));
        }

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            String jwt = jwtService.generateToken(username);

            Map<String, String> response = new HashMap<>();
            response.put("token", jwt);
            return ResponseEntity.ok(response);

        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body(Map.of("error", "Invalid Credentials"));
        }
    }
}
