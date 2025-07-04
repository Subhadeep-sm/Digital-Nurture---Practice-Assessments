package com.cognizant.orm_learn.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.orm_learn.repository.CountryRepository;
import com.cognizant.orm_learn.model.Country;
import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository repo) {
        this.countryRepository = repo;
    }

    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    @Transactional
    public void updateCountry(String code, String name) {
        countryRepository.findById(code).ifPresent(country -> {
            country.setName(name);
            countryRepository.save(country);
        });
    }

    @Transactional
    public Country findCountryByCode(String code) {
        return countryRepository.findById(code).orElse(null);
    }
}
