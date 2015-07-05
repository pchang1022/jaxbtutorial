package com.phoebe.chang.guava;

import com.google.common.base.Predicate;
import com.phoebe.chang.domain.City;
import com.phoebe.chang.domain.Climate;

/**
 * Created by phoebe on 7/5/15.
 */
public class TemperateClimatePredicate implements Predicate<City>{

    public boolean apply(City input) {
        return input.getClimate().equals(Climate.TEMPERATE);
    }



}
