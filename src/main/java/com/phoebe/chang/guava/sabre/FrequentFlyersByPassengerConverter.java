package com.phoebe.chang.guava.sabre;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public final class FrequentFlyersByPassengerConverter {

    private FrequentFlyersByPassengerConverter() {
    }

    public static List<FrequentFlyersByLastName> convert(List<FrequentFlyersByPassenger> frequentFlyersByPassengerList) {

        List<FrequentFlyersByLastName> frequentFlyersByLastNames = new ArrayList<FrequentFlyersByLastName>();
        if (frequentFlyersByPassengerList != null && frequentFlyersByPassengerList.size() == 0) {
            return frequentFlyersByLastNames;
        }
        Map<String, List<FrequentFlyersByPassenger>> ffnByLastNameMap = new LinkedHashMap<>();

        for (FrequentFlyersByPassenger frequentFlyersByPassenger : frequentFlyersByPassengerList) {
            String lastName = frequentFlyersByPassenger.getPassenger().getLastName();
            addFrequentFlyerByLastName(frequentFlyersByPassenger, lastName, ffnByLastNameMap);
        }

        for (Map.Entry<String, List<FrequentFlyersByPassenger>> item : ffnByLastNameMap.entrySet()) {
            frequentFlyersByLastNames.add(new FrequentFlyersByLastName(item.getKey(), item.getValue()));
        }
        return frequentFlyersByLastNames;
    }

    private static void addFrequentFlyerByLastName(FrequentFlyersByPassenger frequentFlyerNumberList, String lastName,
                                                   Map<String, List<FrequentFlyersByPassenger>> ffnByLastNameMap) {

        List<FrequentFlyersByPassenger> ffnByPasList = ffnByLastNameMap.get(lastName);
        if (ffnByPasList == null) {
            ffnByPasList = new ArrayList<FrequentFlyersByPassenger>();
        }

        ffnByPasList.add(frequentFlyerNumberList);
        ffnByLastNameMap.put(lastName, ffnByPasList);
    }
}
