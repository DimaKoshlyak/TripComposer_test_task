package ua.kiev.dk.entities;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "countries")
@JsonPropertyOrder({"countryName", "countryISOCode", "cities"})
public class Country implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "country_name")
    private String countryName;
    @Column(name = "country_iso_code")
    private String countryISOCode;
    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private List<City> cities = new ArrayList<City>();

    public Country() {
    }

    public Country(String countryName, String countryISOCode) {
        this.countryName = countryName;
        this.countryISOCode = countryISOCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryISOCode() {
        return countryISOCode;
    }

    public void setCountryISOCode(String countryISOCode) {
        this.countryISOCode = countryISOCode;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
