package ua.kiev.dk.services;

import ua.kiev.dk.entities.Country;

import java.util.List;

/**
 * Created by d.koshlyak on 23.10.2015.
 */
public interface CountryManager {
    void addCountry(Country country);
    List<Country> countriesList();
}
