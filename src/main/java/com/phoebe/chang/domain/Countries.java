package com.phoebe.chang.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by phoebe on 6/28/15.
 */
@XmlRootElement(name="Countries")
public class Countries {

    List <Country>countries = new ArrayList();

    public List <Country> getCountries() {
        return countries;
    }

    @XmlElement(name="Country")
    public void setCountries(List <Country>countries) {
        this.countries = countries;
    }

    public void add(Country country) {
        countries.add(country);
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for( Country museum : this.countries) {
            str.append( museum.toString() );
        }
        return str.toString();
    }
}
