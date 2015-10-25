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
import ua.kiev.dk.entities.Country;
import ua.kiev.dk.services.CountryManager;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Admin on 25.10.2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
@SpringApplicationConfiguration(classes = {PersistenceContextTest.class})
@WebAppConfiguration
public class CountryPersistenceTest {

    @Autowired
    private CountryManager countryManager;

    @Test
    public void findAllCountriesTest() {
        Collection<Country> countries = countryManager.countriesList();
        assertEquals(1, countries.size());
    }

    @Test
    public void addCountryTest() {
        Country country1 = new Country();
        country1.setCountryName("Ukraine");
        country1.setCountryISOCode("UA");
        countryManager.addCountry(country1);

        Country country2 = new Country();
        country2.setCountryName("Italy");
        country2.setCountryISOCode("IT");
        countryManager.addCountry(country2);

        countryManager.addCountry(country1);
        countryManager.addCountry(country2);

        List<Country> countries = countryManager.countriesList();
        assertEquals(3, countries.size());
    }
}
