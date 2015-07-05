package com.phoebe.chang.guava;

import com.google.common.base.CharMatcher;
import org.testng.annotations.Test;
import com.google.common.truth.*;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by phoebe on 7/5/1
 * from Book Getting Started with Google Guava
 */
public class GuavaCharMatcherTest {

    @Test
    public void testRemoveWhiteSpace() {

        String tabsAndSpaces = "String  with    spaces and                  tabs             \n    ";

        String expected = "String with spaces and tabs ";

        String scrubbed = CharMatcher.WHITESPACE.collapseFrom(tabsAndSpaces, ' ');


        assertThat(scrubbed).isEqualTo(expected);



    }

    @Test
    public void testTrimRemoveWhiteSpace() {

        String tabsAndSpaces = "           String  with    spaces and                  tabs             \n    ";

        String expected = "String with spaces and tabs   ";

        String scrubbed = CharMatcher.WHITESPACE.trimAndCollapseFrom(tabsAndSpaces, ' ');

        //assertThat(expected).isNull();
        assertThat(scrubbed).isEqualTo(expected);
        //Truth.ASSERT


    }

}
