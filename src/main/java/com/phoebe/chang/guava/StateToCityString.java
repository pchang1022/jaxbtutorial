package com.phoebe.chang.guava;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.phoebe.chang.domain.State;

/**
 * Created by phoebe on 7/5/15.
 */
public class StateToCityString implements Function<State, String> {

    public String apply(State input) {
        return Joiner.on(", ").join(input.getMainCities());
    }


}
