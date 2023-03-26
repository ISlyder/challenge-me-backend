package com.duviv.challenge.country.presentation;

import com.duviv.challenge.country.model.Continent;
import com.duviv.challenge.country.service.CountryService;
import com.duviv.challenge.country.model.Country;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/countries")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CountryApi {

    private final CountryService countryService;

    public CountryApi(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getCountries() {
        return countryService.getAll();
    }

    @GetMapping("/{name}")
    public Country getCountry(@PathVariable String name) {
        return countryService.getCountryByName(name);
    }

    @GetMapping("/continent/{continent}")
    public List<Country> getCountriesByContinent(@PathVariable String continent) {
        return countryService.getCountriesByContinent(continent);
    }

}
