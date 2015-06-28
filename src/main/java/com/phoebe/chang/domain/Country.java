package com.phoebe.chang.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

/**
 * Created by phoebe on 6/28/15.
 */


@XmlType( propOrder = { "name", "capital", "foundation", "continent", "population"} )
@XmlRootElement(name="Country")
public class Country {
    private int population;
    private String name;
    private String capital;



    private int importance;

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    private String continent;
    LocalDate foundation;

    @XmlElement(name="countryName")
    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name="countryCaptial")
    public void setCapital(String capital) {
        this.capital = capital;
    }

    @XmlAttribute(name="countryImportance", required = true)
    public void setImportance(int importance) {
        this.importance = importance;
    }

    @XmlElement(name="countryFoundataion")
    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setFoundation(LocalDate foundation) {
        this.foundation = foundation;
    }

    @XmlElement(name="countryPopulation")
    public void setPopulation(int population) {
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public int getImportance() {
        return importance;
    }

    public LocalDate getFoundation() {
        return foundation;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Country{");
        sb.append("population=").append(population);
        sb.append(", name='").append(name).append('\'');
        sb.append(", capital='").append(capital).append('\'');
        sb.append(", importance=").append(importance);
        sb.append(", continent='").append(continent).append('\'');
        sb.append(", foundation=").append(foundation);
        sb.append('}');
        return sb.toString();
    }
}
