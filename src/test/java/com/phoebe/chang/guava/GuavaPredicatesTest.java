package com.phoebe.chang.guava;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Sets;
import com.phoebe.chang.domain.City;
import com.phoebe.chang.domain.Climate;
import com.phoebe.chang.domain.Region;
import com.phoebe.chang.domain.State;
import org.testng.annotations.Test;


import java.util.HashMap;
import java.util.Map;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by phoebe on 7/5/15.
 * The Predicates class is a collection of useful methods for working with Predicate instances.
 *
 * Predicates.and  ==> consistent with the Logical AND operator
 */
public class GuavaPredicatesTest {

    PopulationHalfMillionPredicate small = new PopulationHalfMillionPredicate();
    LowRainFallPredicate dry = new LowRainFallPredicate();

    @Test
    public void testPredicatesAnd () {
        Predicate smallAndDry = Predicates.and(small, dry);
        City denton = new City("Denton", "03933", 100000);
        denton.setClimate(Climate.TEMPERATE);
        denton.setRainfall(34.3f);
        assertThat(smallAndDry.apply(denton)).isTrue();

    }
    @Test
    public void testPredicatesOr() {

        Predicate smallAndDry = Predicates.or(small, dry);
        City denton = new City("Denton", "03933", 666000000);
        denton.setClimate(Climate.TEMPERATE);
        denton.setRainfall(34.3f);
        assertThat(smallAndDry.apply(denton)).isTrue();
    }
    @Test
    public void testPredicatesNot() {

        Predicate smallAndDry = Predicates.not(small);
        City dallas = new City("Dallas", "03933", 666000000);

        assertThat(smallAndDry.apply(dallas)).isTrue();
    }




    /*
    To create a predicate that will evaluate whether hte state returned from our fuction is small or large
     */
    @Test
    public void testPredicatesCompose () {

        //Predicate smallAndDry = Predicates.not(small);

        SouthwestOrMidwestRegionPredicate isSouthWestRegion = new SouthwestOrMidwestRegionPredicate();
        Map<String, State> stateMap = setupMapData();
        Function<String, State> lookup = Functions.forMap(stateMap);
        //State ca = lookup.apply("CA");
        Predicate<String> isThisStateInSouthWestRegion = Predicates.compose(isSouthWestRegion, lookup);

        assertThat(isThisStateInSouthWestRegion.apply("TX")).isTrue();
        assertThat(isThisStateInSouthWestRegion.apply("CA")).isFalse();
    }

    private Map<String, State> setupMapData() {
        Map<String, State> stateMap = new HashMap<String, State>();
        State tx = new State("Texas", "TX", Region.SOUTHWEST);
        State ca = new State("California", "CA", Region.NORTHWEST);
        tx.setMainCities(Sets.newHashSet(
                new City("Houston", "03933", 42938383),
                new City("Austin", "29292", 1290383),
                new City("Dallas", "73633", 29389993),
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
