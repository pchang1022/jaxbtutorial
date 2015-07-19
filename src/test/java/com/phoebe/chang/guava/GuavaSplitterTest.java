package com.phoebe.chang.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by phoebe on 7/4/15.
 */
public class GuavaSplitterTest {

    @Test
    public void testJoiner() throws Exception {
        String texts =  "eins;drei;vier;fünf;sechs;sieben";




        List<String> split = Splitter.on(";").splitToList(texts);
        split.toString();

        assertThat(6).isEqualTo(split.size());
        assertThat(split.get(0)).isEqualTo("eins");


    }


    @Test
    public static void testSplitterModifiers () throws Exception {

        String str = "a,,,b,     c, d   ";

        Splitter splitter = Splitter.on(',')
                .omitEmptyStrings()
                .trimResults();
        Iterable result = splitter.split(str);
        String [] resultArrary = Iterables.toArray(result, String.class);


        assertThat(resultArrary.length).isEqualTo(4);
    }


    @Test
    public void testMapSplitter() throws Exception {
    //he MapSplitter class can take a string in which the keys and values are delimited with one value and the key value pair
    // is delimited with another value and returns a Map instance with the entries in the same order as the given string
        Map<String,String> map = Maps.newLinkedHashMap();
        map.put("Audi", "Neckarsulm");
        map.put("VW", "Wolfsburg");
        map.put("Merzedes", "Stuttgart");
        map.put("Porsche", "Stuttgart");
        map.put("Opel", "Rüsselsheim");
        map.put("Ford", "Köln");

        String mapString = "Audi=Neckarsulm;VW=Wolfsburg;Merzedes=Stuttgart;Porsche=Stuttgart;Opel=Rüsselsheim;Ford=Köln";
        Splitter.MapSplitter splitter = Splitter.on(";").withKeyValueSeparator("=");
        Map<String, String> split = splitter.split(mapString);
        assertThat(split).isEqualTo(map);

    }
}
