package com.phoebe.chang.domain;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.time.LocalDate;

/**
 * Created by phoebe on 6/28/15.
 */
public class MyJaxbMarshaller {

    public static void main(String [] args) {

        marshallCountry();
        marshallMultiple();

    }

    private static void marshallMultiple() {
        Country spain = new Country();
        spain.setName("Spain");
        spain.setCapital("Europe");
        spain.setCapital("Madrid");
        spain.setImportance(1);
        spain.setFoundation(LocalDate.of(1469, 10, 19));
        spain.setPopulation(450000000);

        Country usa = new Country();
        usa.setName("USA");
        usa.setCapital("Washington");
        usa.setContinent("America");
        usa.setFoundation( LocalDate.of( 1776, 7, 4 ) );

        Countries countries = new Countries();
        countries.add(spain);
        countries.add(usa);

        JAXBContext jaxbContext = null;
        Marshaller marshaller = null;

        try {
            jaxbContext = JAXBContext.newInstance(Countries.class);

            marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(countries, new File("countries.xml"));
            marshaller.marshal(countries, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }

    private static void marshallCountry() {
        Country spain = new Country();
        spain.setName("Spain");
        spain.setCapital("Europe");
        spain.setCapital("Madrid");
        spain.setImportance(1);
        spain.setFoundation(LocalDate.of(1469, 10, 19));
        spain.setPopulation(450000000);

//        /init jax marshaller
        JAXBContext jaxbContext = null;
        Marshaller marshaller = null;

        try {
            jaxbContext = JAXBContext.newInstance(Country.class);
            marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(spain, new File("country.xml"));
            marshaller.marshal(spain, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


}
