package ua.kiev.dk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ua.kiev.dk.entities.City;
import ua.kiev.dk.repositories.CityRepository;

import java.util.List;

/**
 * Created by d.koshlyak on 23.10.2015.
 */
@Service("cityManager")
public class CityManagerImpl implements CityManager
{
    @Qualifier("cityRepository")
    @Autowired
    private CityRepository cityRepository;

    @Override
    public void addCity(City city) {
        cityRepository.save(city);
    }

    @Override
    public List<City> citiesList() {
        return cityRepository.findAll();
    }
}
