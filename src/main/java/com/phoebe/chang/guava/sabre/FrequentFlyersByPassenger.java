package com.phoebe.chang.guava.sabre;


import java.util.List;


public class FrequentFlyersByPassenger {

    private Passenger passenger;
    private List<FrequentFlyerNumber> frequentFlyerNumbers;


    public FrequentFlyersByPassenger(Passenger passenger, List<FrequentFlyerNumber> frequentFlyerNumbers) {
        this.passenger = passenger;
        this.frequentFlyerNumbers = frequentFlyerNumbers;
    }


    public List<FrequentFlyerNumber> getFrequentFlyerNumbers() {
        return frequentFlyerNumbers;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public int size() {
        return frequentFlyerNumbers.size();
    }
}
