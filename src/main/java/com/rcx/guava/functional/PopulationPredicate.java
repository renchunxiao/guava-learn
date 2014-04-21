package com.rcx.guava.functional;

import com.google.common.base.Predicate;
import com.rcx.guava.entity.City;

public class PopulationPredicate implements Predicate<City>
{
    public boolean apply(City input)
    {
        return input.getPopulation() <= 500000;
    }
    
    
}