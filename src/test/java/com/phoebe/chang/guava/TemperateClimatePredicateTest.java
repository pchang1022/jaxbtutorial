package com.phoebe.chang.guava;

import com.phoebe.chang.domain.City;
import com.phoebe.chang.domain.Climate;
import com.phoebe.chang.domain.State;
import org.testng.annotations.Test;

import java.util.Map;

import static com.google.common.truth.Truth.assertThat;
import static org.testng.Assert.*;

/**
 * Created by phoebe on 7/5/15.
 * Typically, Predicates would be implemented as anonymous classes (In Java 8 - we can use Lamda!!!)
 * Using concrete classes help clarity!
 */
public class TemperateClimatePredicateTest {
    @Test
    public void testApply() {


        TemperateClimatePredicate predicate = new TemperateClimatePredicate();
        City houston = new City("Houston", "03933", 42938383);
        houston.setClimate(Climate.EQUITORIAL);
        assertThat(predicate.apply(houston)).isFalse();


    }
}