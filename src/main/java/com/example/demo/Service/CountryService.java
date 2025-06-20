package com.example.demo.Service;

import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Exception.CountryNotFoundException;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Model.CountryResponse;
import com.example.demo.Model.RestCountriesApiResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CountryService {

	 private final RestTemplate restTemplate = new RestTemplate();
	    private static final String API_URL = "https://restcountries.com/v3.1/alpha/";

	    public CountryResponse getCountryByCode(String code) {
	        String url = API_URL + code;
	        
	       	        try {
	            ResponseEntity<RestCountriesApiResponse[]> response = restTemplate.getForEntity(url, RestCountriesApiResponse[].class);
	            RestCountriesApiResponse restCountry = response.getBody()[0];

	            return new CountryResponse(
	            		
	            	    code.toUpperCase(),
	            	    (restCountry.getName() != null) ? restCountry.getName().getCommon() : null,
	            	    (restCountry.getCapital() != null && !restCountry.getCapital().isEmpty())
	            	        ? restCountry.getCapital().get(0)
	            	        : null,
	            	    restCountry.getRegion(),
	            	    (restCountry.getCurrencies() != null)
	            	        ? new ArrayList<>(restCountry.getCurrencies().keySet())
	            	        : new ArrayList<>(),
	            	    (restCountry.getLanguages() != null)
	            	        ? new ArrayList<>(restCountry.getLanguages().values())
	            	        : new ArrayList<>(),
	            	    (restCountry.getBorders() != null)
	            	        ? restCountry.getBorders()
	            	        : new ArrayList<>(),
	            	    determineSizeCategory(restCountry.getPopulation())
	            	);
	            
	        } catch (HttpClientErrorException.NotFound e) {
	            throw new CountryNotFoundException("Country not found");
	        } catch (Exception e) {
	        	 e.printStackTrace(); 
	            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Upstream API failed");
	        }
	    }

	    private String determineSizeCategory(long population) {
	        if (population < 1_000_000) return "SMALL";
	        if (population < 10_000_000) return "MEDIUM";
	        return "LARGE";
	    }
	}
