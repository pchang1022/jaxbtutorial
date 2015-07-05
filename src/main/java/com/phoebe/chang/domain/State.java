package com.phoebe.chang.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by phoebe on 7/5/15.
 */
public class State {

    private String name;
    private String code;
    private Set<City> mainCities = new HashSet<City>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<City> getMainCities() {
        return mainCities;
    }

    public void setMainCities(Set<City> mainCities) {
        this.mainCities = mainCities;
    }
}
