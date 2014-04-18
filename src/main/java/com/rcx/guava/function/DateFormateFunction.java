package com.rcx.guava.function;

import java.util.Date;

import org.joda.time.DateTime;

import com.google.common.base.Function;

public class DateFormateFunction implements Function<Date, String>
{
    public String apply(Date input)
    {
        return new DateTime(input).toString("yyyy-MM-dd");
    }
}
