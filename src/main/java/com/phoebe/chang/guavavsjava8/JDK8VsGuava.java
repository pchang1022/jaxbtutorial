package com.phoebe.chang.guavavsjava8;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by phoebe on 9/6/15.
 * <p>
 * https://weblogs.java.net/blog/bhaktimehta/archive/2014/07/14/how-jdk-8-standardizes-and-augments-guava-library-functionalities
 * <p>
 * 9/6/15
 * <p>
 * Functionality	Guava	JDK 8
 * Predicate	apply(T input)	test(T input)
 * Combining predicates	Predicates.and/or/not	Predicate.and/or/negate
 * Supplier	Suplier.get	Supplier.get
 * Joiner/StringJoiner	Joiner.join()	StringJoiner.add()
 * SettableFuture/CompletableFuture	SettableFuture.set(T input)	CompletableFuture.complete(T input)
 * Optional	Optional.of/ofNullable/empty	Optional.of/fromNullable/absent
 */


public class JDK8VsGuava {
    public static void main(String[] args) {

        Stream<Person> jdk8 = getPersonOver50();
        jdk8.toArray();
        Collection guava = getPersonOver50_Guava();

        System.out.println("done");

    }

    public static Stream<Person> getPersonOver50() {

        List<Person> persons = Person.createList();

        Stream<Person> over30s = persons.stream()
                .filter(p -> p.getAge() > 30);
        return over30s;

    }


    public static Collection getPersonOver50_Guava() {

        List<Person> persons = Person.createList();

        Predicate over30 =  new Predicate<Person>() {
            public boolean apply( Person input) {
                return input.getAge() > 30;
            }
        };


        Collection ps = Collections2.filter(persons, (p -> p.getAge() > 30));

        return ps;

    }


}
