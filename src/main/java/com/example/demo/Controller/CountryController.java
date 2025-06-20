package com.example.demo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.InvalidCountryCodeException;
import com.example.demo.Model.CountryResponse;
import com.example.demo.Service.CountryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/countries")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService = new CountryService();

    @GetMapping("/{code}")
    public ResponseEntity<CountryResponse> getCountry(@PathVariable String code) {
        if (!code.matches("^[A-Z]{2}$")) {
            throw new InvalidCountryCodeException("Invalid country code format.");
        }
        CountryResponse response = countryService.getCountryByCode(code);
        return ResponseEntity.ok(response);
      
       
       
    }
}
