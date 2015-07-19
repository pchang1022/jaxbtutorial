package com.phoebe.chang.guava.sabre;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;
import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by phoebe on 7/19/15.
 */
public class FrequentFlyersByPassengerConverterTest {


    @Test
    public void testGet_ForPassengersWithoutFrequentFlyerNumbers() {

        List<FrequentFlyersByPassenger> frequentFlyersByPassenger = newArrayList(
                new FrequentFlyersByPassenger(new Passenger("Phoebe", "Chang"),
                        newArrayList(new FrequentFlyerNumber("AA", "111111"), new FrequentFlyerNumber("UA", "PHOEBE_UA"))),
                new FrequentFlyersByPassenger(new Passenger("Wanda", "Chang"),
                        newArrayList(new FrequentFlyerNumber("AA", "222222"), new FrequentFlyerNumber("UA", "WANDA_UA"))),
                new FrequentFlyersByPassenger(new Passenger("Hana", "Wang"),
                        newArrayList(new FrequentFlyerNumber("AA", "333333"), new FrequentFlyerNumber("UA", "HANA_UA")))
        );
        assertNotNull(frequentFlyersByPassenger);
        assertEquals(3, frequentFlyersByPassenger.size());

        List<FrequentFlyersByLastName> frequentFlyersByLastNames = FrequentFlyersByPassengerConverter.convert(frequentFlyersByPassenger);
        assertNotNull(frequentFlyersByLastNames);
        assertEquals(2, frequentFlyersByLastNames.size());
    }


}