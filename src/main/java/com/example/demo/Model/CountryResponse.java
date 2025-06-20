package com.example.demo.Model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public class CountryResponse {

	    private String countryCode;
	    private String name;
	    private String capital;
	    private String region;
	    private List<String> currencies;
	    private List<String> languages;
	    private List<String> borders;
	    private String sizeCategory;

	    public CountryResponse(String countryCode, String name, String capital, String region,
	                           List<String> currencies, List<String> languages,
	                           List<String> borders, String sizeCategory) {
	        this.countryCode = countryCode;
	        this.name = name;
	        this.capital = capital;
	        this.region = region;
	        this.currencies = currencies;
	        this.languages = languages;
	        this.borders = borders;
	        this.sizeCategory = sizeCategory;
	    }

	    // Getters and Setters (or use Lombok if preferred)
	    public String getCountryCode() {
	        return countryCode;
	    }

	    public void setCountryCode(String countryCode) {
	        this.countryCode = countryCode;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getCapital() {
	        return capital;
	    }

	    public void setCapital(String capital) {
	        this.capital = capital;
	    }

	    public String getRegion() {
	        return region;
	    }

	    public void setRegion(String region) {
	        this.region = region;
	    }

	    public List<String> getCurrencies() {
	        return currencies;
	    }

	    public void setCurrencies(List<String> currencies) {
	        this.currencies = currencies;
	    }

	    public List<String> getLanguages() {
	        return languages;
	    }

	    public void setLanguages(List<String> languages) {
	        this.languages = languages;
	    }

	    public List<String> getBorders() {
	        return borders;
	    }

	    public void setBorders(List<String> borders) {
	        this.borders = borders;
	    }

	    public String getSizeCategory() {
	        return sizeCategory;
	    }

	    public void setSizeCategory(String sizeCategory) {
	        this.sizeCategory = sizeCategory;
	    }
	}


