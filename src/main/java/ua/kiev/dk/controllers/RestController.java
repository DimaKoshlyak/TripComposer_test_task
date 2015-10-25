package ua.kiev.dk.controllers;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.kiev.dk.entities.City;
import ua.kiev.dk.entities.Country;
import ua.kiev.dk.entities.JSONResponse;
import ua.kiev.dk.services.CityManager;
import ua.kiev.dk.services.CountryManager;

import java.io.File;
import java.io.IOException;
import java.util.List;

@ComponentScan("ua.kiev.dk")
@Controller
@RequestMapping("/tripcomposer")
public class RestController {

    @Autowired
    private CountryManager countryManager;

    @Autowired
    private CityManager cityManager;

    @RequestMapping(value = "/")
    public ModelAndView homePage() throws IOException {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/json")
    public ModelAndView test() throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        JSONResponse jsonResponse = mapper.readValue(new File("d:\\tripcomposer.json"), JSONResponse.class);

        List<Country> countries = jsonResponse.getCountries();
        System.out.println(countries.size());
        for (Country country : countries) {
            countryManager.addCountry(country);
            List<City> cities = country.getCities();
            for (City city : cities) {
                city.setCountry(country);
                cityManager.addCity(city);
            }
        }
        return new ModelAndView("cities","cities",cityManager.citiesList());
    }

    //TODO: try to solve the problem with script sending
    @RequestMapping(value = "/post",
            method = RequestMethod.POST,
            consumes = "application/json;charset=UTF-8",
            produces = "application/json;charset=UTF-8")
    public City create(@RequestBody City p) {

        System.out.println("DONE!");

        return p;
    }
}

//this method response to POST request http://localhost/spring-mvc-json/rest/cont/person
// receives json data sent by client --> map it to Person object
// return Person object as json
//    @RequestMapping(value=URL,
//                    method = RequestMethod.POST,
//                    produces = "application/json",
//                    headers = "key = $1$12309856$euBrWcjT767K2sP9MHcVS/")
//    public @ResponseBody
//    Person post( @RequestBody final  Person person) {
//
//        System.out.println(person.getId() + " " + person.getName());
//        return person;
//    }

