package com.phoebe.chang.guava;

import com.google.common.base.Joiner;
import org.apache.commons.collections.ListUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by phoebe on 7/4/15.
 */
public class GuavaJoiner {


    public static void main(String[] args) {
        List<String> stringList = new ArrayList();
        stringList.add("first");
        stringList.add("second");
        stringList.add("third");
        stringList.add("fourth");
        stringList.add(null);

        String join = Joiner.on(" | ").skipNulls().join(stringList);
        join = Joiner.on(" | ").useForNull("null").join(stringList);




        System.out.println(join);


        StringBuilder stringBuilder = new StringBuilder();
        Joiner joiner = Joiner.on("|").skipNulls();
        //returns the StringBuilder instance with the values foo,bar,baz  appeneded with "|" delimiters
        joiner.appendTo(stringBuilder, "foo", "bar", "baz");




        //The Joiner class can be used with classes that implement the Appendable interface.

        FileWriter fileWriter = null ;
        try {
            fileWriter = new FileWriter(new File("path"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Integer [] intArray = {1, 2, 3, 4, 5};
        List<Integer> intList = Arrays.asList(intArray);

        Joiner joiner2 = Joiner.on("#").useForNull(" ");
        //returns the FileWriter instance with the values appended into it
        try {
            joiner2.appendTo(fileWriter, intList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("done");
    }



}
