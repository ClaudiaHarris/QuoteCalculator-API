package com.claudiavharris.quoteapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")  // This makes all endpoints start with /api
public class QuoteController {

    @GetMapping("/")  // Handles requests to "/"
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Quote API is running!");
    }
}
