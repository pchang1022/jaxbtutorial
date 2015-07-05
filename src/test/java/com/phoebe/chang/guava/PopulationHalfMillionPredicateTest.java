package com.phoebe.chang.guava;

import com.google.common.collect.Sets;
import com.phoebe.chang.domain.City;
import com.phoebe.chang.domain.State;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.truth.Truth.assertThat;
import static org.testng.Assert.*;

/**
 *
 *
 * Created by phoebe on 7/5/15.
 * The Predicate Interface is a functional cousin to the Function interface.  Like the Function interface,
 * the Predicate interface has 2 methods.
 *
 * the Function interface is used to TRANSFORM objects.
 * the Predicate interface is used to FILTER objects
 */
public class PopulationHalfMillionPredicateTest {

    @Test
    public void testApply() {
        Map<String, State> stateMap = setupMapData();

        PopulationHalfMillionPredicate predicate = new PopulationHalfMillionPredicate();
        City houston = new City("Houston", "03933", 42938383);
        assertThat(predicate.apply(houston)).isFalse();

        City denton = new City("Denton", "03933", 100000);
        assertThat(predicate.apply(denton)).isTrue();
    }

    private Map<String, State> setupMapData() {
        Map<String, State> stateMap = new HashMap<String, State>();
        State tx = new State("Texas", "TX");
        State ca = new State("California", "CA");
        tx.setMainCities(Sets.newHashSet(
                new City("Houston", "03933", 42938383),
                new City("Austin",  "29292", 1290383),
                new City("Dallas",  "73633", 29389993),
                new City("San Antonio", "23980", 293039)));
        stateMap.put(tx.getCode(), tx);

        ca.setMainCities(Sets.newHashSet(
                new City("Los Angeles", "39393", 38309239),
                new City("Santa Monica", "39393", 234433),
                new City("San Fransciso", "39393", 3423344),
                new City("Oakland", "39393", 334444)));
        stateMap.put(ca.getCode(), ca);


        return stateMap;
    }
}