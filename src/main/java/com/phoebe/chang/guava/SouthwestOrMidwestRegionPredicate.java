package com.phoebe.chang.guava;

import com.google.common.base.Predicate;
import com.phoebe.chang.domain.Region;
import com.phoebe.chang.domain.State;

/**
 * Created by phoebe on 7/5/15.
 */
public class SouthwestOrMidwestRegionPredicate implements Predicate<State>{

    public boolean apply(State input) {

        return input.getRegion().equals(Region.MIDWEST) || input.getRegion().equals(Region.SOUTHWEST);
    }


}
