package com.rcx.guava.functional;

import com.google.common.base.Predicate;
import com.rcx.guava.entity.City;
import com.rcx.guava.enums.Climate;

public class TemperateClimatePredicate implements Predicate<City>
{
    public boolean apply(City input)
    {
        return input.getClimate().equals(Climate.TEMPERATE);
    }
}