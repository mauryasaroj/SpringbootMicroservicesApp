package com.example.demo.Model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestCountriesApiResponse {

    private Name name;
    private List<String> capital;
    private String region;
    private long population;
    private Map<String, CurrencyDetail> currencies;
    private Map<String, String> languages;
    private List<String> borders;

    // --- Getters and Setters ---

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public List<String> getCapital() {
        return capital;
    }

    public void setCapital(List<String> capital) {
        this.capital = capital;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public Map<String, CurrencyDetail> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Map<String, CurrencyDetail> currencies) {
        this.currencies = currencies;
    }

    public Map<String, String> getLanguages() {
        return languages;
    }

    public void setLanguages(Map<String, String> languages) {
        this.languages = languages;
    }

    public List<String> getBorders() {
        return borders;
    }

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    // Nested classes

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Name {
        private String common;

        public String getCommon() {
            return common;
        }

        public void setCommon(String common) {
            this.common = common;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CurrencyDetail {
        private String name;
        private String symbol;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }
    }
}
