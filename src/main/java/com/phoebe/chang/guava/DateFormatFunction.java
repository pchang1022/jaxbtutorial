package com.phoebe.chang.guava;

import com.google.common.base.Function;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by phoebe on 7/5/15.
 * To learn the Function Interface
 */
public class DateFormatFunction implements Function<ZonedDateTime, String>{

    private final String dateTimeFormatPattern = "yyyy/MM/dd HH:mm:ss z";

    public String apply(ZonedDateTime input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormatPattern);
        return formatter.format(input);
    }
}
