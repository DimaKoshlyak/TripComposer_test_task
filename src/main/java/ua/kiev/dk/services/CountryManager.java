package ua.kiev.dk.services;

import ua.kiev.dk.entities.Country;

import java.util.List;

public interface CountryManager {
    void addCountry(Country country);
    List<Country> countriesList();
}
