package com.claudiavharris.quoteapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")  // This makes all endpoints start with /api
public class QuoteController {

    @GetMapping("/")  // Handles requests to "/api/"
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Quote API is running!");
    }

    @PostMapping("/calculate-quote")  // Handles POST requests to "/api/calculate-quote"
    public ResponseEntity<String> calculateQuote(@RequestBody QuoteRequest request) {
        double quote = calculateInsuranceQuote(request.getAge(), request.getYears(), request.isAccidents());
        return ResponseEntity.ok("Your insurance quote is: $" + quote);
    }

    private double calculateInsuranceQuote(int age, int years, boolean hasAccidents) {
        double basePrice = 500.0;
        if (age < 25) basePrice += 200;
        if (years > 5) basePrice -= 50;
        if (hasAccidents) basePrice += 150;
        return basePrice;
    }
}
