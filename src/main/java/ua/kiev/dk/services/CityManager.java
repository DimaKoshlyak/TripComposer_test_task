package ua.kiev.dk.services;

import ua.kiev.dk.entities.City;

import java.util.List;

/**
 * Created by d.koshlyak on 23.10.2015.
 */
public interface CityManager {
    void addCity(City city);
    List<City> citiesList();
}
