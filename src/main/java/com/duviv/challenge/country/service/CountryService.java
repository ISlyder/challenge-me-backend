package com.duviv.challenge.country.service;

import com.duviv.challenge.country.model.Continent;
import com.duviv.challenge.country.model.CountriesList;
import com.duviv.challenge.country.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Component
public class CountryService {

    private final List<Country> countries;

    @Autowired
    public CountryService() {
        countries = new ArrayList<>();
        for (CountriesList c : CountriesList.values()) {
            countries.add(c.getCountry());
        }
    }

    public Country getCountryByName(String name) {
        return this.countries.stream()
                .filter(country -> country.getName().equalsIgnoreCase(name))
                .findFirst().orElseThrow(() -> new NoSuchElementException("No country with name " + name));
    }

    public List<Country> getAll() {
        return this.countries.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Country> getCountriesByContinent(String continent) {
        return this.countries.stream()
                .filter(country -> country.getContinent().getName().equals(continent))
                .collect(Collectors.toList());
    }

}
