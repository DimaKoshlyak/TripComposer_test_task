package ua.kiev.dk.services;

import ua.kiev.dk.entities.City;

import java.util.List;

public interface CityManager {
    void addCity(City city);
    List<City> citiesList();
}
