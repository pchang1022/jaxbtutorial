package com.phoebe.chang.domain;

/**
 * Created by phoebe on 7/5/15.
 */
public class City {

    private String name;
    private String zipCode;



    private float rainfall;

    private int population;
    private Climate climate;


    public City (String name, String zipCode, int population) {
        this.name = name;
        this.zipCode = zipCode;
        this.population = population;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }


    public Climate getClimate() {
        return climate;
    }

    public void setClimate(Climate climate) {
        this.climate = climate;
    }

    public float getRainfall() {
        return rainfall;
    }

    public void setRainfall(float rainfall) {
        this.rainfall = rainfall;
    }



    public String toString() {
        return name;
    }
}
