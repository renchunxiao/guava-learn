package com.rcx.guava.functional;

import com.google.common.base.Predicate;
import com.rcx.guava.entity.City;

public class LowRainfallPredicate implements Predicate<City> {

    public boolean apply(City input)
    {
        return input.getAverageRainfall() < 45.7;
    }
}