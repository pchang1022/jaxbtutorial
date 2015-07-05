package com.phoebe.chang.guava;



import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Sets;
import com.phoebe.chang.domain.City;
import com.phoebe.chang.domain.State;
import org.testng.annotations.Test;

import javax.naming.spi.StateFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by phoebe on 7/5/15.
 */
public class GuavaFunctionsTest {

    @Test
    public void testFunctionsForMap () {


        Map<String, State> stateMap = setupMapData();
        Function<String, State> lookup = Functions.forMap(stateMap);
        State ca = lookup.apply("CA");

        assertThat("CA").isEqualTo(ca.getCode());
    }

    @Test
    public void testFunctionsCompose() {

        Map<String, State> stateMap = setupMapData();
        Function<String, State> lookup = Functions.forMap(stateMap);

        Function<State, String> stateFunction = new StateToCityString();
        Function<String, String> composed = Functions.compose(stateFunction, lookup);

        String ca = composed.apply("CA");

        String tx = composed.apply("TX");
        // Same as following

        String caCities = stateFunction.apply(lookup.apply("CA"));
        String txCities = stateFunction.apply(lookup.apply("TX"));

        assertThat(ca).isEqualTo(caCities);
        assertThat(tx).isEqualTo(txCities);

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
