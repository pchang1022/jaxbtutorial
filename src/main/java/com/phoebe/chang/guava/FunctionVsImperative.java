package com.phoebe.chang.guava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Stopwatch;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multiset;


import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.google.common.collect.Lists.asList;
import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by phoebe on 7/19/15.
 *
 * See https://code.google.com/p/guava-libraries/wiki/FunctionalExplained
 */
public class FunctionVsImperative {


    static Function<String, Integer> lengthFunction = new Function<String, Integer>() {
        public Integer apply(String string) {
            return string.length();
        }
    };
    static Predicate<String> allCaps = new Predicate<String>() {
        public boolean apply(String string) {
            return CharMatcher.JAVA_UPPER_CASE.matchesAllOf(string);
        }
    };

    public static void main(String[] args) {
        List<String> strings = newArrayList("ABCadfadf", "ASDFLKASDJF1axclvksd", "ADSFLKASDFJ");

        for (int i=0; i<=100; i++){
            //Multiset<Integer> lengths = functional(strings);
            Multiset<Integer> lengths2 =  imperative(strings);
        }
        //Multiset<Integer> lengths2 =  imperative(strings);

        //System.out.printf(" lenghts: %d%n", new Object[]{lengths.size()});

        //System.out.printf(" lenghts2: %d%n", new Object[]{lengths2.size()});

    }
    static Multiset<Integer>  functional (List<String> strings) {
        final Stopwatch stopwatch = Stopwatch.createStarted();
        Multiset<Integer> lengths = HashMultiset.create(
                Iterables.transform(Iterables.filter(strings, allCaps), lengthFunction));
        System.out.println("Elapsed time in NANOSECONDS ==> " + stopwatch.elapsed(TimeUnit.NANOSECONDS));
        return lengths;
    }

    static Multiset<Integer>  imperative (List<String> strings) {
        final Stopwatch stopwatch = Stopwatch.createStarted();
        Multiset<Integer> lengths = HashMultiset.create();
        for (String string : strings) {
            if (CharMatcher.JAVA_UPPER_CASE.matchesAllOf(string)) {
                lengths.add(string.length());
            }
        }

        System.out.println("Elapsed time in NANOSECONDS ==> " + stopwatch.elapsed(TimeUnit.NANOSECONDS));
        return lengths;
    }


}
