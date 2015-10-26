package ua.kiev.dk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ua.kiev.dk.entities.Country;
import ua.kiev.dk.repositories.CountryRepository;

import java.util.List;

@Service("countryManager")
public class CountryManagerImpl implements CountryManager
{
    @Qualifier(value = "countryRepository")
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    @Override
    public List<Country> countriesList() {
        return countryRepository.findAll();
    }
}
