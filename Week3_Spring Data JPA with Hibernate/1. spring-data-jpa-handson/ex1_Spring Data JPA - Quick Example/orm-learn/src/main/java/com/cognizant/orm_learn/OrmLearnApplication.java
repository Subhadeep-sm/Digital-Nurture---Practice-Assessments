package com.cognizant.orm_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.ApplicationContext;
import com.cognizant.orm_learn.model.Country;

import com.cognizant.orm_learn.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
  private static CountryService countryService;

  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
    LOGGER.info("Inside main");

    countryService = context.getBean(CountryService.class);
    testGetAllCountries();
    testAddCountry();
    testUpdateCountry();
  }

  private static void testGetAllCountries() {
    LOGGER.info("Start - getAllCountries");
    LOGGER.debug("countries={}", countryService.getAllCountries());
    LOGGER.info("End - getAllCountries");
  }

  private static void testAddCountry() {
    LOGGER.info("Start - addCountry");
    Country c = new Country("FR", "France");
    countryService.addCountry(c);
    LOGGER.debug("After add, fetched={}", countryService.findCountryByCode("FR"));
    LOGGER.info("End - addCountry");
  }

  private static void testUpdateCountry() {
    LOGGER.info("Start - updateCountry");
    countryService.updateCountry("FR", "French Republic");
    LOGGER.debug("After update, fetched={}", countryService.findCountryByCode("FR"));
    LOGGER.info("End - updateCountry");
  }
}

