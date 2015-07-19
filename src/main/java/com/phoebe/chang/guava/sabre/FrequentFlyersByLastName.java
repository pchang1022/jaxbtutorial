package com.phoebe.chang.guava.sabre;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sg0222678 on 7/7/15.
 */
public class FrequentFlyersByLastName implements Serializable {

    String lastName;
    List<FrequentFlyersByPassenger> frequentFlyersByPassengerList;

    public FrequentFlyersByLastName(String lastName, List<FrequentFlyersByPassenger> frequentFlyersByPassengerList) {
        this.lastName = lastName;
        this.frequentFlyersByPassengerList = frequentFlyersByPassengerList;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<FrequentFlyersByPassenger> getFrequentFlyersByPassengerList() {
        return frequentFlyersByPassengerList;
    }

    public void setFrequentFlyersByPassengerList(List<FrequentFlyersByPassenger> frequentFlyersByPassengerList) {
        this.frequentFlyersByPassengerList = frequentFlyersByPassengerList;
    }
}