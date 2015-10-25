package ua.kiev.dk.controllers;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ua.kiev.dk.entities.City;
import ua.kiev.dk.entities.Country;
import ua.kiev.dk.entities.JSONResponse;
import ua.kiev.dk.services.CityManager;
import ua.kiev.dk.services.CountryManager;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@ComponentScan("ua.kiev.dk")
@Controller
@RequestMapping("/tripcomposer")
public class RestController {

    private final static String REQUEST_URL = "http://tripcomposer.net/rest/test/countries/get";
    private final static String REQUEST_STRING = "{\"key\" : \"$1$12309856$euBrWcjT767K2sP9MHcVS/\"}";

    @Autowired
    private CountryManager countryManager;

    @Autowired
    private CityManager cityManager;

    @RequestMapping(value = "/")
    public ModelAndView homePage() throws IOException {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/json_from_file")
    public ModelAndView jsonFromFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JSONResponse jsonResponse = mapper.readValue(new File("tripcomposer.json"), JSONResponse.class);
        List<Country> countries = jsonResponse.getCountries();
        addToDatabase(countries);
        return new ModelAndView("cities", "cities", cityManager.citiesList());
    }

    @RequestMapping(value = "/json_simple_request")
    public ModelAndView jsonSimpleRequest() throws Exception {
        String jsonStringResponse = "";
        ObjectMapper mapper = new ObjectMapper();
        jsonStringResponse = sendJSONRequest();
        JSONResponse jsonResponse = mapper.readValue(jsonStringResponse, JSONResponse.class);
        List<Country> countries = jsonResponse.getCountries();
        addToDatabase(countries);
        return new ModelAndView("cities", "cities", cityManager.citiesList());
    }

    //TODO: try to solve the problem with script sending
    @RequestMapping(value = "/post",
            method = RequestMethod.POST,
            consumes = "application/json;charset=UTF-8",
            produces = "application/json;charset=UTF-8")
    public ModelAndView jsonJQueryRequest(@RequestBody JSONResponse jsonResponse) {
        List<Country> countries = jsonResponse.getCountries();
        addToDatabase(countries);
        return new ModelAndView("cities", "cities", cityManager.citiesList());
    }

    public void addToDatabase(List<Country> countries) {
        for (Country country : countries) {
            countryManager.addCountry(country);
            List<City> cities = country.getCities();
            for (City city : cities) {
                city.setCountry(country);
                cityManager.addCity(city);
            }
        }
    }

    public String sendJSONRequest() throws Exception {
        URL url = new URL(REQUEST_URL);
        StringBuffer response = new StringBuffer();
        String inputString = "";

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        urlConnection.setRequestMethod("POST");
        urlConnection.setDoOutput(true);

        DataOutputStream outputStream = new DataOutputStream(urlConnection.getOutputStream());
        try {
            outputStream.writeBytes(REQUEST_STRING);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            outputStream.flush();
            outputStream.close();
        }

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(urlConnection.getInputStream()));
        try {
            while ((inputString = bufferedReader.readLine()) != null) {
                response.append(inputString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
        }
        return response.toString();
    }
}

