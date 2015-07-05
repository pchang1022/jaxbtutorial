package com.phoebe.chang.guava;

import org.testng.annotations.Test;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import static com.google.common.truth.Truth.assertThat;


/**
 * Created by phoebe on 7/5/15.
 */
public class DateFormatFunctionTest {
    private final String dateTimeFormatPattern = "yyyy/MM/dd HH:mm:ss z";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormatPattern);

    @Test
    public void testZonedDateTimeFormat() {
        String expected = "2015/07/05 10:07:08 CDT";
        //ZonedDateTime now8 = ZonedDateTime.now();
        ZonedDateTime now8 = ZonedDateTime.parse(expected, formatter);
        DateFormatFunction myFunc = new DateFormatFunction();
        String actual = myFunc.apply(now8);
        System.out.println (now8 + " formated = " + actual );
        assertThat(actual).isEqualTo(expected);

        //
    }

}