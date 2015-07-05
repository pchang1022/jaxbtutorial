package com.phoebe.chang.guava;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Joiner;
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
 * https://gist.github.com/K0NRAD/8898732
 */

public class GuavaJoinerTest {

    @Test
    public void testJoiner() throws Exception {
        List<String> texts = Lists.newArrayList("eins", null, "drei", "vier", "fünf", "sechs", "sieben", null);

        String joined;
        String expected;

        joined = Joiner.on(";")
                .skipNulls()
                .join(texts);

        expected = "eins;drei;vier;fünf;sechs;sieben";
        assertThat(expected).isNotEmpty();
        assertThat(joined).isEqualTo(expected);

        joined = Joiner.on(";")
                .useForNull("missing")
                .join(texts);
        expected = "eins;missing;drei;vier;fünf;sechs;sieben;missing";
        assertThat(joined).isEqualTo(expected);

    }
    @Test
    public void testJoinerWithClassesThatImplementAppendeableInterface() throws Exception {
        List<String> texts = Lists.newArrayList("1000200030004", "Apple", "MacBook Pro", null, "false");

        File file = File.createTempFile("guava","study");
        FileWriter fileWriter = new FileWriter(file);

        Joiner.on(";")
                .useForNull("N/A")
                .appendTo(fileWriter, texts);
        fileWriter.close();

        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String csvLine = reader.readLine();
        reader.close();
        String expected = "1000200030004;Apple;MacBook Pro;N/A;false";
        assertThat(csvLine).isEqualTo(expected);

        file.delete();
    }

    @Test
    public static void testJoinerWithStringBuilder () throws Exception {


//        List<String> texts = Lists.asList("Never", "change", "a", "thing!");
        List<String> temp = Lists.asList("Never", new String[] {"change", "a", null, "thing!"});
        //same as
        List<String> texts = Lists.newArrayList("Never", "change", "a", null, "thing!");

        assertThat(temp).isEqualTo(texts);

        StringBuilder sb = new StringBuilder();

        Joiner.on(" ").useForNull("___").appendTo(sb, texts);

        String expected = "Never change a ___ thing!";

        assertThat(sb.toString()).isEqualTo(expected);
    }


    @Test
    public void testMapJoiner() throws Exception {

        Map<String,String> map = Maps.newLinkedHashMap();
        map.put("Audi", "Neckarsulm");
        map.put("VW", "Wolfsburg");
        map.put("Merzedes", "Stuttgart");
        map.put("Porsche", "Stuttgart");
        map.put("Opel", "Rüsselsheim");
        map.put("Ford", "Köln");

        String joined = Joiner.on(";").withKeyValueSeparator("=").join(map);
        String expected = "Audi=Neckarsulm;VW=Wolfsburg;Merzedes=Stuttgart;Porsche=Stuttgart;Opel=Rüsselsheim;Ford=Köln";
        assertThat(joined).isEqualTo(expected);
    }
}