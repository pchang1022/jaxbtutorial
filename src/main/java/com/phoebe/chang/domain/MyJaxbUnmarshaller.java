package com.phoebe.chang.domain;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by phoebe on 6/28/15.
 */
public class MyJaxbUnmarshaller {

    public static void main(String [] args) {

        unmarshal();

    }

    private static void unmarshal() {
        File file = new File("countries.xml");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Countries.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Countries countries = (Countries) unmarshaller.unmarshal(file);
            System.out.println(countries);
        } catch (JAXBException e) {
            e.printStackTrace();
        }



    }

}
