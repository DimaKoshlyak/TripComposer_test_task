package ua.kiev.dk.entities;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({"type", "time", "countries"})
public class JSONResponse implements Serializable {

    private String type;
    private long time;

    private List<Country> countries = new ArrayList<Country>();

    public JSONResponse() {
    }

    public JSONResponse(String type, int time) {
        this.type = type;
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}
