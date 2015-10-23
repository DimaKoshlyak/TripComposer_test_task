package ua.kiev.dk;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import ua.kiev.dk.config.PersistenceContextTest;
import ua.kiev.dk.entities.City;
import ua.kiev.dk.entities.Country;
import ua.kiev.dk.services.CityManager;
import ua.kiev.dk.services.CountryManager;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by d.koshlyak on 23.10.2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
@SpringApplicationConfiguration(classes = {PersistenceContextTest.class})
@WebAppConfiguration

public class CityPersistenceTest {
    @Autowired
    private CityManager cityManager;

    @Autowired
    private CountryManager countryManager;

    @Test
    public void findAllCitiesTest() {
        Collection<City> crews = cityManager.citiesList();
        assertEquals(0, crews.size());
    }

    @Test
    public void addCityTest() {
        Country country = new Country();
        country.setCountryName("UA");
        country.setCountryISOCode("sss");
        countryManager.addCountry(country);

        City city1 = new City();
        city1.setCityName("Kiev");
        city1.setCountry(country);

        City city2 = new City();
        city2.setCityName("Dnepr");
        city2.setCountry(country);

        cityManager.addCity(city1);
        cityManager.addCity(city2);

        List<City> cityList = cityManager.citiesList();
        assertEquals(2, cityList.size());
    }
}
