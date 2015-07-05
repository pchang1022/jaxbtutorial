package com.phoebe.chang.guava;

import com.google.common.base.Predicate;
import com.phoebe.chang.domain.City;

/**
 * Created by phoebe on 7/5/15.
 */
public class PopulationHalfMillionPredicate implements Predicate<City> {


    public boolean apply(City input) {
        return input.getPopulation() <= 500000;
    }

}
